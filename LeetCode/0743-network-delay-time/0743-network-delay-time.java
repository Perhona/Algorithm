import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int[] neighbor = {time[1], time[2]};
            adjacencyList.get(time[0]).add(neighbor);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});
        int out = Integer.MIN_VALUE, count = 0;

        while (!pq.isEmpty()) {
            int[] nodeTime = pq.poll();
            int node = nodeTime[0];

            if (nodeTime[1] > dist[node]) {
                continue;
            }

            dist[node] = nodeTime[1];
            out = Math.max(out, dist[node]);
            count++;

            for (int[] neighbor : adjacencyList.get(node)) {
                if (dist[node] + neighbor[1] < dist[neighbor[0]]) {
                    // int[] updatedNeighbor = {neighbor[0], dist[node] + neighbor[1]};
                    // pq.add(updatedNeighbor);

                    dist[neighbor[0]] = dist[node] + neighbor[1];
                    pq.add(new int[]{neighbor[0], dist[neighbor[0]]});
                }
            }
        }

        return count == n ? out : -1;
    }
}