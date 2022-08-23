import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int[] alphabet = new int[26]; // 출력할 알파벳 배열 선언
    byte[] ascii = st.nextToken("").getBytes(); // 입력받은 단어의 아스키코드를 받을 byte 배열
  
    Arrays.fill(alphabet, -1);  // 알파벳 배열 -1로 초기화

    for (int i = 0; i < ascii.length; i++) {  // a의 아스키 코드는 97이므로 alphabet배열과 맞추기 위해 -97
      int checkAscii = ascii[i] - 97;
      if (alphabet[checkAscii] == -1){  // 이미 -1 외의 숫자가 있는 경우는 넘어감
        alphabet[checkAscii] = i;
      }
    }

    for (int j : alphabet) {
      sb.append(j).append(" ");
    }
    System.out.println(sb);
  }
}