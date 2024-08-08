class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            backTrack(result, nums, new ArrayList<>(), i, 0);
        }
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, List<Integer> path, int n, int startIdx) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(result, nums, path, n, i + 1);
            path.remove(path.size() - 1);
        }
    }
}