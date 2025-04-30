import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conditions = br.readLine().split(" ");
        int[] dots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int lineCnt = Integer.parseInt(conditions[1]);

        for (int i = 0; i < lineCnt; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            System.out.println(upperBound(dots, end) - lowerBound(dots, start));
        }

    }

    /* 배열에 포함된 수 중 해당 값 이상의 인덱스 찾기 */
    /* target 이상인 첫 값 찾기 */
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {    // 탐색중인 값이 타겟값보다 작으면 버린다.
                left = mid + 1;         // mid가 정답이 될 수 없으므로 +1
            } else {
                right = mid;            // 탐색중인 값이 타겟값과 같거나 크면 정답 가능성이 있음
            }
        }
        return right;
    }

    /* target 첫 초과값 찾기 */
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
