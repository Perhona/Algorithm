import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 동시 신호 전달이 가능
        // 갔다 왔는지, 갈수 있는 조합인지, 더 효율적인 루트인지 어떻게 판단? -> Map에 가장 작은 가중치부터 삽입해서 판단. 시작 노드부터 도착 노드별 최소 가중치 계산 하면 된다.
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        Map<Integer, Integer> dist = new HashMap<>();   // 시작 노드부터 도착 노드별 최단 거리 Map
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            int u = cur.getKey();
            int dist_u = cur.getValue();

            // dist에 u 키 값이 존재하지 않는다면 u에 대한 가장 작은 가중치의 value일 것임
            if (!dist.containsKey(u)) {
                dist.put(u, dist_u);
                if (graph.containsKey(u)) { // 그래프에서 노드 u가 존재한다면
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) { // 연결된 노드, 가중치 순회
                        int alt = dist_u + v.getValue();    // 현재까지의 가중치 + 연결된 노드의 가중치
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt)); // pq 에 해당 노드와 노드까지의 가중치 저장
                    }
                }
            }
        }
        if (dist.size() == n) { // dist size가 n과 같다는 뜻은 시작 노드로부터 도달 가능 노드가 n개, 즉 모두 도달 가능하다는 뜻
            return Collections.max(dist.values());  // 8개의 네트워크가 시작 노드로부터 출발했다면, 가장 오래 걸린 노드의 값이 곧 모든 노드가 신호를 받을 수 있는 최대 시간
        }

        return -1;
    }
}