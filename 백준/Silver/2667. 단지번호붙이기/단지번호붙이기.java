import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int HOUSE_COUNT = 0;
    public static int N = 0;
    public static char[][] MAP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MAP = new char[N][N];

        // map에 입력받은 값 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = line.charAt(j);
            }
        }

        int groupCount = 0;
        List<Integer> houses = new ArrayList<>();
        // 행렬을 순회하며 집이 존재하면('1') 상하좌우 DFS 진행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                HOUSE_COUNT = 0;
                if (MAP[i][j] == '1') {
                    dfs(i, j);
                    groupCount++;
                    houses.add(HOUSE_COUNT);
                }
            }

        }
        
        // 출력
        System.out.println(groupCount);
        houses.stream().sorted().forEach(System.out::println);
    }

    private static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N || MAP[i][j] == '0') {
            return;
        }

        // 집을 발견한 경우 0 처리, 집의 수 + 1
        MAP[i][j] = '0';
        HOUSE_COUNT++;

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}