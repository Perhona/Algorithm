import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    if (a/10==0){
      a= a*10;
    }
    int x = a;
    int y;
    int z;
    int count = 1;

    while (true){
      y = x/10 + x%10;  //  1. 2+6 = 8 / 2. 6+8 = 14
      z = x%10*10 + y%10;  //  1. 60+8 = 68 / 2. 80+4 = 84  새로운 수
      if (z!=a){
        x = z;
      } else break;
      count++;
    }
    System.out.println(count);
  }
}

