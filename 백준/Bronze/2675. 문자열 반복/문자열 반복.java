import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            String s = input[1];
            String[] arr = s.split("");
            for (String string : arr) {
                sb.append(string.repeat(n));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
