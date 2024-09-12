class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> resultList = new ArrayList<>();

        for (int[] i : intervals) {
            // resultList의 마지막 배열의 두번째 값이 순회중인 i의 첫번째 값보다 크거나 같다면 겹침
            int[] arr = resultList.isEmpty() ? null : resultList.get(resultList.size() - 1);
            
            if (!resultList.isEmpty() && arr[1] >= i[0]) {
                arr[1] = Math.max(arr[1], i[1]);
            } else {
                resultList.add(i);  // 첫번째 배열은 무조건 삽입됨
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}