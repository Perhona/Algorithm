import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cases = Integer.parseInt(br.readLine());

    for (int i = 0; i < cases; i++) {  // 테스트 케이스만큼 번복
      String str = br.readLine(); // 주어진 테스트 케이스 한 줄 읽음
      int repeat = str.charAt(0) - '0'; // 아스키 코드 숫자 83로 변환된 repeat에서 '0'을 빼줌(80)

      for (int j = 0; j < str.length() - 2; j++) { //전체 길이에서 반복횟수와 공백을 뺀 길이만큼 반복
        for (int k = 0; k < repeat; k++) {       // 주어진 반복횟수만큼 출력
          System.out.print(str.charAt(j + 2));
        }
      }
    System.out.println();
    }
  }
}