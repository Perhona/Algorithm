import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
    StringTokenizer st;

    for (int i = 0; i < x; i++) {   // 한 줄씩 반복
      st = new StringTokenizer(br.readLine());
      char[] arr = st.nextToken().toCharArray();  // 한 줄을 캐릭터 배열로 바꿈
      int score = 0;     
      int temp = 0;   // 연속 여부에 따라 값을 더해줄 변수
        
      for (int j = 0; j < arr.length; j++) {  // 한 줄 안의 캐릭터 배열 반복
        if (arr[j] == 'O') {    // 한 요소가 O이면 1씩 더해준다.
          score = score + temp + 1;
          temp++; // 연속 여부에 따른 추가 값
        } else {
          temp = 0; // X가 나올 경우 추가 값은 0이 됨
        }
      }
      System.out.println(score);
    }
    br.close();
  }
}