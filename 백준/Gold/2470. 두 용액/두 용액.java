import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[2];
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int leftIdx = 0;
        int rightIdx = liquids.length - 1;
        int min = Integer.MAX_VALUE;

        while (leftIdx < rightIdx) {
            int sum = liquids[leftIdx] + liquids[rightIdx];
            int absSum = Math.abs(sum);

            /* 절댓값이 작아졌는지 확인 -> 정답을 갱신할지 기준 */
            /* 틀렸던 이유: 절댓값이 작아졌다는 사실은 "정답을 갱신할 조건"일 뿐, "어떤 포인터를 움직일지 결정하는 기준"은 아님 */
            if (absSum < min) {
                min = absSum;
                result[0] = liquids[leftIdx];
                result[1] = liquids[rightIdx];
            }

            /* 포인터를 움직이는 기준 -> 기준값 (0) 이상/이하/같음 */
            if (sum < 0) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}