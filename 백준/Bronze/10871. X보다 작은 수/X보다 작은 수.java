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

    String firstLine = br.readLine();
    StringTokenizer st = new StringTokenizer(firstLine);
    int x = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    StringTokenizer numbers = new StringTokenizer(br.readLine());
    for (int i=0;i<x;i++){
      int a = Integer.parseInt(numbers.nextToken());
      if (a<n){
        bw.write(a+" ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
