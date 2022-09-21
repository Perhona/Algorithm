import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int aa = (a%10)*100 + ((a/10)%10)*10 + ((a/100)%10);
    int bb = (b%10)*100 + ((b/10)%10)*10 + ((b/100)%10);
    if (aa > bb) {
      System.out.println(aa);
    } else {
      System.out.println(bb);
    }

  }
}