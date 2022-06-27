import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    if (b>45){
      System.out.print(a);
      System.out.println();
      System.out.print(b-45);
    }
    if (b==45){
      System.out.print(a);
      System.out.println();
      System.out.print("0");
    }
    if (b<45){
      if (a==0){
        System.out.print("23");
        System.out.println();
        System.out.print(60+(b-45));
      } else {
        System.out.print(a-1);
        System.out.println();
        System.out.print(60+(b-45));
      }
    }
  }
}
