import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
    StringTokenizer st;

    for (int i=0;i<x;i++){  // 테스트 케이스의 개수만큼 반복
      st = new StringTokenizer(br.readLine());
      
      int students = Integer.parseInt(st.nextToken()); // 맨 앞의 학생 수
      double[] stuArr = new double[students]; // 학생 수 크기의 배열 생성
      double sum = 0;

      for (int j=0;j<stuArr.length;j++){  // 각 줄의 학생 점수 배열 생성 및 합계
        stuArr[j] = Double.parseDouble(st.nextToken());
        sum = sum + stuArr[j];
      }

      double ave = sum / students ; // 평균 계산
      
      // 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력
      double aveStu = 0;  // 평균이 넘는 학생 수
      for (int k=0;k<stuArr.length;k++){
        if (stuArr[k]>ave){
          aveStu++;
        }
      }
      System.out.printf("%.3f%s%n", aveStu/students*100, "%");
    }

    br.close();
  }
}