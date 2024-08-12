class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        // 출발지-도착지 그래프 만들기
        for (List<String> ticket : tickets) {
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(results, fromToMap, "JFK");
        return results;
    }

    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
        // Map에서 from 지점이 있고, 해당 지점의 value가 비어있지 않다면 반복
        // 다음으로 연결되는 지점이 없다면 반복하지 않음(즉, 마지막 경로)
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }
        // 마지막 지점부터 추가
        results.add(0, from);
    }
}