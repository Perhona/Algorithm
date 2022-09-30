import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int sum = 0;
    for (int i = 0; i < str.length(); i++) {
      int m = checkDial(String.valueOf(str.charAt(i)));
      sum += m;
    }
    System.out.println(sum);
  }

  public static int checkDial(String s) {
    int n = 0;
    switch (s) {
      case "A":
      case "B":
      case "C":
        n = 3;
        break;
      case "D":
      case "E":
      case "F":
        n = 4;
        break;
      case "G":
      case "H":
      case "I":
        n = 5;
        break;
      case "J":
      case "K":
      case "L":
        n = 6;
        break;
      case "M":
      case "N":
      case "O":
        n = 7;
        break;
      case "P":
      case "Q":
      case "R":
      case "S":
        n = 8;
        break;
      case "T":
      case "U":
      case "V":
        n = 9;
        break;
      case "W":
      case "X":
      case "Y":
      case "Z":
        n = 10;
        break;
    }
    return n;
  }
}
