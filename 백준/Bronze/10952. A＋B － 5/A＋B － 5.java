import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    while (true){
      StringTokenizer numbers = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(numbers.nextToken());
      int b = Integer.parseInt(numbers.nextToken());

      if (a==0&&b==0) break;

      bw.write(a+b+"\n");

    }

    bw.flush();
    bw.close();
    br.close();
  }
}
