class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 0, new ArrayDeque<>());

        return result;
    }

    private void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        // 모든 탐색 경로를 결과에 저장한다. 빈 집합('[]')도 맨 처음 저장된다.
        results.add(new ArrayList<>(path));

        // 가장 처음 0이 index로 들어온다.
        // 저장된 nums[0]은 다음 재귀함수 호출 시 먼저 저장된다.
        // index는 1이 되어 nums[1]부터 반복을 시작한다.
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(results, nums, i + 1, path);
            path.removeLast();
        }
    }
}