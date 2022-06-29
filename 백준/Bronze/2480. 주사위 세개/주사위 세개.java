import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (a==b && b==c){
      System.out.println(10000 + a*1000);
    } else if (a==b){
      System.out.println(1000 + a*100);
    } else if (b==c){
      System.out.println(1000 + b*100);
    } else if (c==a){
      System.out.println(1000 + c*100);
    }
    if (a!=b && b!=c && c!=a){
      int x = 0;
      if (a>b && a>c) x = a;
      if (b>c && b>a) x = b;
      if (c>b && c>a) x = c;
      System.out.println(x*100);
    }

  }
}
