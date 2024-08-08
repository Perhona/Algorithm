class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
                dfs(result, nums, 0, new ArrayDeque<>());

        return result;
    }

    private void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {
        results.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(results, nums, i + 1, path);
            path.removeLast();
        }
    }
}