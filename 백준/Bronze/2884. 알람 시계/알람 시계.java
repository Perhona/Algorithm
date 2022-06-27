import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    if (b>45){
      System.out.println(a);
      System.out.println(b-45);
    }
    if (b==45){
      System.out.println(a);
      System.out.println("0");
    }
    if (b<45){
      if (a==0){
        System.out.println("23");
      } else {
        System.out.println(a-1);
      }
      System.out.println(60+(b-45));
    }
  }
}
