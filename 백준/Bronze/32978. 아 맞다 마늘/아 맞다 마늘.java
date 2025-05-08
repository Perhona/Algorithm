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
        boolean[] used = new boolean[N];

        for (String usedIngredient : usedIngredients) {
            int idx = Arrays.binarySearch(ingredients, usedIngredient);
            used[idx] = true;
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                System.out.println(ingredients[i]);
                break;
            }
        }
    }
}
