import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String duplicated = "?";
        String none = "!";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int songDataCnt = Integer.parseInt(condition[0]);
        int songQuestionCnt = Integer.parseInt(condition[1]);
        Map<String, String> songData = new HashMap<>();

        for (int i = 0; i < songDataCnt; i++) {
            String[] input = br.readLine().split(" ");
            String title = input[1];
            String notes = input[2] + input[3] + input[4];
            songData.put(title, notes);
        }

        for (int i = 0; i < songQuestionCnt; i++) {
            String question = br.readLine().replace(" ", "");
            String result = "";

            for (Map.Entry<String, String> note : songData.entrySet()) {
                if (note.getValue().equals(question)) {
                    result = result.isEmpty() ? note.getKey() : duplicated;
                }
            }
            System.out.println(result.isEmpty() ? "!" : result);
        }
    }
}
