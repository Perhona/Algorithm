import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int blurayCnt = Integer.parseInt(input[1]);
        int[] classes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 찾아야 하는 값: 최대 강의 길이(강의 합)
        int left = Arrays.stream(classes).max().getAsInt();     /* 가장 긴 강의 길이도 한 장에 들어가야 함 */
        int right = Arrays.stream(classes).sum();

        while (left < right) {  // 정답이 없을수도 있으니 <=가 아닌 < ?
            int mid = (left + right) / 2;
            /* mid 값 초과 전까지 강의 길이 합 더하기 */
            int sum = 0;
            int cnt = 1;        /* 첫번째 블루레이 사용 시작 */
            for (int aClass : classes) {
                sum += aClass;
                if (sum > mid) {
                    cnt++;
                    sum = aClass;
                }
            }

            /* n을 구해서, n이 블루레이 갯수보다 많으면 더 큰 mid값을, 적으면 더 작은 mid 값을 */
            if (cnt <= blurayCnt) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
