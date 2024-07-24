class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 배열의 요소와 빈도 수를 HashMap에 저장
        // 2. Stream API를 사용해 1) value 기준 정렬 2) key값만 추출 3) k 갯수만큼 추출 4) int형 배열로 반환

        // 1
        Map<Integer, Integer> elements = new HashMap<>();
        for (int i : nums) {
//            elements.put(i, elements.containsKey(i) ? elements.get(i) + 1 : 1); // 3항 연산자 사용
            elements.put(i, elements.getOrDefault(i, 0) + 1); // getOrDefault 사용
        }

        // 2
        return elements.entrySet()                                  // Set<Entry<K,V>> 형태로 변경
                .stream()                                           // 데이터 요소를 다루기 위한 Stream 객체로 변환
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())  // value 값으로 내림차순 정렬 (o2.getValue().compareTo(o1.getValue())
                .limit(k)                                           // k개 만큼 갯수 제한
                .mapToInt(Map.Entry::getKey)                        // map() => toArray 시 Object[] or Integer[]로 반환됨
                .toArray();
    }
}