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

        // 최소 비용을 추적하는 배열, 초기값은 매우 큰 값으로 설정
        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;

        // 경유 횟수를 추적하는 배열, 초기값은 매우 큰 값으로 설정
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minStops[src] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int price = current[1];
            int stops = current[2];

            // 목적지 도달 시, 해당 경로의 비용 반환
            if (node == dst) {
                return price;
            }

            // 경유 횟수가 k를 초과하면 더 이상 진행하지 않음
            if (stops > k) continue;

            // 인접 노드 탐색
            for (int[] neighbor : adjacencyList.get(node)) {
                int nextNode = neighbor[0];
                int nextPrice = price + neighbor[1];

                // 더 적은 비용이거나, 동일한 경유 횟수로 더 적은 비용일 경우만 진행
                if (nextPrice < minPrice[nextNode] || stops + 1 < minStops[nextNode]) {
                    minPrice[nextNode] = nextPrice;
                    minStops[nextNode] = stops + 1;
                    pq.add(new int[]{nextNode, nextPrice, stops + 1});
                }
            }
        }

        // 목적지에 도달할 수 없을 경우 -1 반환
        return -1;
    }
}