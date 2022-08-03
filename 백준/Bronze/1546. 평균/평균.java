import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine());
    double[] score = new double[x];       // 원래 성적을 담을 배열
    double[] fixedScore = new double[x];  // 바뀐 성적을 담을 배열
    double max; // 최고 점수

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0;i<x;i++){  // 현재 성적을 담을 배열
      score[i] = Integer.parseInt(st.nextToken());
    }
//    System.out.println("score[]는"+ Arrays.toString(score));

    max = score[0]; // 최초 최고점수 값은 배열의 첫 값으로 지정
//    System.out.println("max는"+max);
    for (int i=1;i<x;i++){  // 최고점수 값 비교하여 지정
      if (max<score[i]){
        max = score[i];
      }
    }
//    System.out.println("바뀐 max는"+max);

    double temp = 0;  // 모든 성적을 더한 값
    for (int i=0;i<x;i++){  // 바뀐 성적으로 배열에 저장
//      System.out.println(score[i]+" "+max);
//      System.out.println(score[i]/max);
      fixedScore[i] = score[i] / max * 100;
      temp = temp+fixedScore[i];
    }
//    System.out.println("fixedScore[]는"+ Arrays.toString(fixedScore));
    System.out.println(temp / x); // 평균값 도출

  }
}