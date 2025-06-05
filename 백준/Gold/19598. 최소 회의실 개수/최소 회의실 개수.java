import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            meetings.add(new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1])});
        }
        meetings.sort(Comparator.comparing(n -> n[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetings.get(0)[1]);

        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i < meetings.size(); i++) {
            int prevMeeting = pq.poll();
            if (meetings.get(i)[0] < prevMeeting) pq.add(prevMeeting);
            pq.add(meetings.get(i)[1]);
        }
        System.out.println(pq.size());
    }
}
