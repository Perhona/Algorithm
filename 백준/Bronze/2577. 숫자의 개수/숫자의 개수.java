import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    int num = a * b * c;
    int count = 0;  // 자릿수
    int temp = num;

    /* num 자릿수 계산 */
    while (temp>0) {
      temp = temp/10;
      count++;
    }

    int[] countNum = new int[10]; // 0~9까지의 값 갯수를 넣어줄 배열

    for (int i=0;i<count;i++) {  // 곱한 숫자의 자릿수만큼 반복
      for (int j=0;j<10;j++){   // 0~9까지의 값 갯수 구하기
        if (num%10 == j){ // 맨끝 자릿수와 0~9 숫자 비교
          countNum[j]++;
        }
      }
      num = num/10;
    }

    /* 결과 출력*/
    for (int k=0;k<10;k++){
      System.out.println(countNum[k]);
    }
  }
}