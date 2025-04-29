import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long left = 1;
        long right = max;
        long mid;
        long cnt;   // 누적 시 int 범위 초과 가능성 있음
        long result = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            cnt = 0;
            for (int n : lines) {
                cnt += n / mid;
            }
            if (cnt < N) {
                right = mid - 1;
            } else {
                result = Math.max(result, mid);
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
