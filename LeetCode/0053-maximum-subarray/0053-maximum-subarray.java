class Solution {
    public int maxSubArray(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
            sums.add(sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return sums.stream().max(Comparator.comparingInt(o -> o)).get();
    }
}