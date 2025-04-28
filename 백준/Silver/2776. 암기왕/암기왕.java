import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());    // 수첩1 정수의 개수
            HashSet<String> note1 = new HashSet<>();    // 수첩1 내용
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                note1.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());    // 수첩2 정수의 개수
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (note1.contains(st.nextToken())) {   // contains()로 즉시 비교
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }
}
