class Solution {
    public int[][] merge(int[][] intervals) {   // 10ms
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> resultList = new ArrayList<>();
        dfs(resultList, intervals, intervals[0], 1 );

        return resultList.toArray(new int[resultList.size()][]);
    }

    private void dfs(List<int[]> result, int[][] arr, int[] a, int idx) {
        // 비교하면서 연결고리가 없는 경우 result에 넣고, 있는 경우 dfs 계속
        if (idx > arr.length-1) {
            result.add(a);
            return;
        }

        int x = a[0], y = a[1];
        int x2 = arr[idx][0], y2 = arr[idx][1];
        if (x <= x2 && x2 <= y) {
            a[0] = x;
            a[1] = Math.max(y, y2);
        } else {
            result.add(new int[]{x, y});
            a[0] = x2;
            a[1] = y2;
        }

        dfs(result, arr, a, idx + 1);
    }
}