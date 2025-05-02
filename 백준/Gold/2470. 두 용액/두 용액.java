import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[2];
        int[] liquids = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int leftIdx = 0;
        int rightIdx = liquids.length - 1;
        int min = Integer.MAX_VALUE;

        while (leftIdx < rightIdx) {
            int sum = liquids[leftIdx] + liquids[rightIdx];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                result[0] = liquids[leftIdx];
                result[1] = liquids[rightIdx];
            }

            if (sum >= 0) {
                rightIdx -= 1;
            } else {
                leftIdx += 1;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
