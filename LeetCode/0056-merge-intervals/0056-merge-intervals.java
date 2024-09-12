class Solution {
    public int[][] merge(int[][] intervals) { // 10ms
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> resultList = new ArrayList<>();
        dfs(resultList, intervals, intervals[0], 1);

        return resultList.toArray(new int[resultList.size()][]);
    }

    private void dfs(List<int[]> result, int[][] arr, int[] a, int idx) { // a: 비교대상, idx: arr 인덱스
        // 비교하면서 연결고리가 없는 경우 result에 넣고, 있는 경우 dfs 계속

        if (idx > arr.length - 1) { // 다음 비교대상 위치를 가리키는 idx가 범위를 넘어가는 경우
            result.add(a); // 갱신되어 넘어온 a 저장 후 종료
            return;
        }

        int x = a[0], y = a[1];
        int x2 = arr[idx][0], y2 = arr[idx][1];

        if (x2 <= y) {
            a[1] = Math.max(y, y2);
        } else {
            result.add(new int[]{x, y});    // 겹치지 않는 경우 저장 및 a 갱신
            a[0] = x2;
            a[1] = y2;
        }

        dfs(result, arr, a, idx + 1);
    }
}