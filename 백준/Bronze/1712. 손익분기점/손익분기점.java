import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long C = Long.parseLong(st.nextToken());
    long n = 1;
    /*
     * A: 고정비용, B: 가변비용, C: 상품가격, n: 상품판매량
     * 손익분기점: A+ B*n < C*n
     * */
    if (B < C) {
//      while (A + B * n >= C * n) { // 비용이 상품 판매가격보다 높은 동안 반복
//        n++;
//      }
      System.out.println(A / (C-B) + 1);
    } else {
      System.out.println(-1);
    }
  }
}

