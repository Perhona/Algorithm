import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = 0;
    int sum = 0;

    while (b<a){ // a 만큼 반복
      b++;
      sum = sum + b;
      if (b==a){
        System.out.println(sum);
      }
    }
  }
}
