class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 인접 리스트 초기화
        List<List<int[]>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjacencyList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // 우선순위 큐 초기화, 큐 요소는 {현재 노드, 현재 비용, 경유 횟수}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0, 0});

        // 비용 배열 초기화
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curPrice = current[1];
            int curStops = current[2];

            // 도착지에 도달하거나, 경유 횟수가 최대를 초과하는 경우
            if (curNode == dst) {
                return curPrice;
            }

            if (curStops > k) {
                continue;
            }

            // 이웃 노드를 탐색
            for (int[] neighbor : adjacencyList.get(curNode)) {
                int nextNode = neighbor[0];
                int newPrice = curPrice + neighbor[1];

                // 새로운 경로가 더 저렴하면 갱신 및 큐에 추가
                if (newPrice < prices[nextNode] || curStops + 1 < stops[nextNode]) {
                    stops[nextNode] = newPrice;
                    prices[nextNode] = newPrice;
                    pq.add(new int[]{nextNode, newPrice, curStops + 1});
                }
            }
        }

        return -1;
    }
}