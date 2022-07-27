import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int[] b = new int[a];
    int max, min;
    
    StringTokenizer st = new StringTokenizer(br.readLine());
      
    for (int i=0;i<a;i++){
      b[i] = Integer.parseInt(st.nextToken());
    }
    max = b[0];
    min = b[0];
      
    for (int j=1;j<b.length;j++){
      if (max < b[j]){
        max = b[j];
      }
      if (min > b[j]){
        min = b[j];
      }
    }
    System.out.println(min + " " + max);
  }
}

