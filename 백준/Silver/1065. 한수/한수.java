import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findHansu(Integer.parseInt(br.readLine())));
    }

    static int findHansu(int x) {
        int result = 0;
        for (int i = 1; i < x+1; i++) {
            if (i < 100) {
                result++;
            } else if (i < 1000) {
                int a = (i / 10) % 10 - (i / 100) % 10; // 10의 자리수 - 100의 자리수
                int b = i % 10 - (i / 10) % 10;       // 1의 자리수 - 10의 자리수
                if (a == b) {
                    result++;
                }
            }
        }
        return result;
    }
}
