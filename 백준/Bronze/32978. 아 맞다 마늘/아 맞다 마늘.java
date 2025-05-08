import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] ingredients = br.readLine().split(" ");
        String[] usedIngredients = br.readLine().split(" ");

        Arrays.sort(ingredients);
        Arrays.sort(usedIngredients);

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.println(ingredients[i]);
            }

            if (!ingredients[i].equals(usedIngredients[i])) {
                System.out.println(ingredients[i]);
                break;
            }
        }
    }
}
