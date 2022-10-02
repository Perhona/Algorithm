import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 1;
        String s = String.valueOf(str.charAt(0));

        for (int i = 0; i < str.length() - 1; i++) {
            s += str.charAt(i + 1);
            if (s.equals("dz")) {
                if (i + 2 < str.length() && str.charAt(i + 2) == '=') {
                    cnt--;
                }
            }
            if (!checkAlphabet(s)) {
                cnt++;
            }
            s = String.valueOf(str.charAt(i + 1));
        }
        System.out.println(cnt);
    }

    public static boolean checkAlphabet(String s) {
        String[] alphabetList = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        boolean returnValue = false;

        for (String value : alphabetList) {
            if (s.equals(value)) {
                returnValue = true;
            }
        }
        return returnValue;
    }
}
