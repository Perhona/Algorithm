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

        Map<String, Boolean> cookingMap = new HashMap<>();

        for (String used : usedIngredients) {
            cookingMap.put(used, false);
        }

        for (String original : ingredients) {
            if (cookingMap.get(original) == null) {
                System.out.println(original);
                break;
            }
        }
    }
}
