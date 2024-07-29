import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int house = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int count = 0;
        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                house = 0;
                if (map[i][j] == '1') {
                    bfs(n, i, j, map);
                    count++;
                    houses.add(house);
                }
            }

        }
        System.out.println(count);
        houses.stream().sorted().forEach(System.out::println);
    }

    private static void bfs(int n, int i, int j, char[][] map) {
        if (i < 0 || j < 0 || i >= n || j >= n || map[i][j] == '0') {
            return;
        }

        map[i][j] = '0';
        house++;

        bfs(n, i - 1, j, map);
        bfs(n, i + 1, j, map);
        bfs(n, i, j - 1, map);
        bfs(n, i, j + 1, map);
    }
}