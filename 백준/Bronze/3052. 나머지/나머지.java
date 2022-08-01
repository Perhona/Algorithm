import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] remainder = new int[10];  // 나머지를 넣어줄 배열 생성
    int count = 0;                  // 서로 다른 나머지의 갯수
    int x = 1;

    for (int i=0;i<10;i++){
      remainder[i] = Integer.parseInt(br.readLine()) % 42;
    } // 입력 받을 때마다 배열에 42로 나눈 나머지 값을 넣어준다.
    br.close();
//    System.out.println(Arrays.toString(remainder)); 나머지값 확인

    for (int j=0;j<9;j++){  // 배열의 첫번째 요소 기준, 끝 값까지 비교하는 이중 반복문
      for (int k=x;k<=9;k++){
        if (remainder[j] == remainder[k]) { // 이전요소를 제외한 나머지 요소들과 각각 비교해 일치하는 경우 -1 입력
          remainder[k] = -1;
        }
      }
      x++;
    }
//    System.out.println(Arrays.toString(remainder)); 중복값이 -1로 바뀐 배열 확인

    for (int k=0;k<10;k++){ // 중복값을 처리한 -1을 제외한 나머지 수 확인
      if (remainder[k]>=0){
        count++;
      }
    }
    System.out.println(count);
  }
}