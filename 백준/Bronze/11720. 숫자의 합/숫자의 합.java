import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine());
    int numbers = 0;
    String str = br.readLine();
    for (int i=0;i<x;i++){
      String a = String.valueOf(str.charAt(i));
      int intA = Integer.parseInt(a);
      numbers += intA;
    }

    System.out.println(numbers);

  }
}