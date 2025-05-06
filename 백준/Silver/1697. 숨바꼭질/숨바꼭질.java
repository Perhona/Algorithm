import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int MIN = 0;
        int MAX = 100_000;
        boolean[] visited = new boolean[MAX + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, N});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int time = now[0];
            int position = now[1];

            if (position == M) {
                System.out.println(time);
                break;
            }

            int[] move = {position - 1, position + 1, position * 2};

            for (int n : move) {
                if (n >= MIN && n <= MAX && !visited[n]) {
                    visited[n] = true;
                    queue.add(new int[]{time + 1, n});
                }
            }
        }
    }
}
