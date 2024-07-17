class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);

        int target = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;
            int targetSum = target - nums[i];

            while (leftIdx < rightIdx) {
                if (leftIdx > i + 1 && nums[leftIdx] == nums[leftIdx - 1]) {
                    leftIdx++;
                    continue;
                }

                int sum = nums[leftIdx] + nums[rightIdx];
                if (sum == targetSum) {
                    output.add(List.of(nums[i], nums[leftIdx], nums[rightIdx]));
                }

                if (targetSum < sum) {
                    rightIdx--;
                } else  {
                    leftIdx++;
                }
            }
        }
        return output;
    }
}