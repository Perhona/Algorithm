import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    static boolean[][] visited;
    static List<Integer> result;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        
        /* 문제 조건 생성 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();
        
        /* 그리드 초기화 */
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        /* 집 위치(단지)가 끊겨 있으므로 전체 그리드 탐색 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                /* 지도에 집이 존재하고 방문하지 않았을 때, 주변 탐색 시작 */
                if (houses[i][j] != 0 && !visited[i][j]) {
                    bfs(new int[]{i, j});
                }
            }
        }
        
        /* 답 출력 */
        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    static void bfs(int[] position) {
        /* 방문 수, 방문 위치 초기화 */
        int houseCnt = 1;
        visited[position[0]][position[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(position);
        
        /* 상하좌우 순회 시작 */
        while (!queue.isEmpty()) {
            int[] currPosition = queue.poll();
            int x = currPosition[0];
            int y = currPosition[1];

            for (int i = 0; i < 4; i++) {
                int nextPosX = x + dx[i];
                int nextPosY = y + dy[i];
                if (isAvailableRange(nextPosX, nextPosY) && houses[nextPosX][nextPosY] != 0 && !visited[nextPosX][nextPosY]) {
                    queue.add(new int[]{nextPosX, nextPosY});
                    visited[nextPosX][nextPosY] = true;
                    houseCnt++;
                }
            }
        }
        result.add(houseCnt);
    }

    static boolean isAvailableRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
