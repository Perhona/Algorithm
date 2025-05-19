import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 입력: NXM크기의 정사각형
 *   0 < N, M <= 50
 * 로직: 꼭짓점에 쓰여 잇는 수가 모두 같은 가장 큰 '정사각형' 찾기
 *   1. 꼭짓점이 0이 아닌 경우 같은 숫자 찾으면 탐색
 * 출력: 정답 정사각형의 크기
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < nums.length; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int maxIdxDiff = 0; // 가장 큰 차 저장
        int result = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = grid[i][j];
                for (int k = j + 1; k < M; k++) {
                    if (grid[i][k] == num && (k - j) > maxIdxDiff) {    // 우상단 체크 & 차이 비교
                        int idxDiff = k - j;
                        // 밑변 X좌표 유효성 && 값 체크
                        int downX = i + idxDiff;
                        if (downX < N && grid[downX][j] == num && grid[downX][k] == num) {
                            maxIdxDiff = idxDiff;
                            int length = idxDiff + 1;
                            result = Math.max(result, length * length);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
