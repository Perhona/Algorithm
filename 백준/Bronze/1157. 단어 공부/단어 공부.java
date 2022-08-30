import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toUpperCase(Locale.ROOT);
    int[] alphabet = new int[26]; // 알파벳의 사용 횟수를 표시할 int 배열 선언

    for (int i = 0; i < str.length(); i++) {
      alphabet[str.charAt(i) - 'A']++;
    } // 주어진 단어의 알파벳 자릿수에 쓰인 만큼 더함

    int biggest = 0;      // 가장 큰 수
    int biggestChar = 0;  // 가장 큰 수를 가진 배열의 인덱스
    
    for (int i = 0; i < alphabet.length; i++) { // 알파벳 배열을 전체 반복하여 가장 큰 수와 그 자릿수 반환
      if (alphabet[i] > biggest) {
        biggest = alphabet[i];  // 가장 큰 수 삽입
        biggestChar = i;        // 가장 큰 수를 가진 그 인덱스 삽입
      } else if (alphabet[i] == biggest) {
        biggestChar = -1;       // 가장 큰 수가 알파벳 배열 내에 또 존재한다면 인덱스로 -1 삽입
      }
    }
    
    if (biggestChar == -1) {
      System.out.println("?");
    } else {
      System.out.println((char) (biggestChar + 'A'));
    }
  }
}
