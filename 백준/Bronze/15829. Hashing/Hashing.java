import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        long sum = 0;
        int r = 31;

        for (int i = 0; i < input.length; i++) {
            int toInt = input[i] - 'a' + 1;
            sum += (long) (toInt * (Math.pow(r, i)));
        }
        System.out.println(sum % 1_234_567_891);
    }
}
