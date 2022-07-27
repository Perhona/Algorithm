import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] numbers = new int[9];
    for (int i=0; i<9; i++){
      numbers[i] = Integer.parseInt(br.readLine());
    }

    int max = numbers[0];
    int index = 1;

    for (int j=0; j<numbers.length-1; j++){
      if (max < numbers[j+1]){
        max = numbers[j+1];
        index = j+2;
      }
    }
    System.out.println(max + "\n" + index);

  }
}

