class Solution {
    public void sortColors(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int b = nums[i];
            int idx = i;
            while (idx > 0 && toSwap(b, nums[idx - 1])) {
                int a = nums[idx - 1];
                nums[idx] = a;
                nums[idx - 1] = b;
                idx--;
            }
        }
    }

    private boolean toSwap(int a, int b) {
        return a < b;
    }
}