class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 키(h) 내림차순 정렬
        // 키가 같다면 순서(k) 오름차순 정렬
        // 큰 키부터 앞에 배치하면서, k에 따라 인덱스로 추가해주면 된다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        pq.addAll(Arrays.asList(people));
        List<int[]> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }
        return result.toArray(people);
    }
}