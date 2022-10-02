import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /*
         * 첫 줄의 단어 갯수 n을 확인하여 n만큼 반복하며 그룹단어를 찾는다.
         * 그룹단어가 아닌 단어를 체크해주는 notGroupN 변수를 선언해주고,
         * n번의 반복문 안에서 단어의 길이가 1 이상인 동안
         * 단어의 첫글자를 떼어내 삭제한 뒤 단어 속에 떼어낸 첫글자가 있는지 확인한다.
         * 있으면 notGroupN을 1 증가시켜 주고, while문을 탈출한 뒤 다음 n번째 반복문을 수행한다.
         * */

        int notGroupN = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            while (sb.length() > 1) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                if (sb.indexOf(String.valueOf(c)) != 0
                        && sb.indexOf(String.valueOf(c)) != -1) {
                    notGroupN++;
                    break;
                }
            }
        }
        System.out.println(n - notGroupN);
    }
}
