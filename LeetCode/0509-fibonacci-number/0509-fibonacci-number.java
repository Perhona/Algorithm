class Solution {
    private int[] nums = new int[31];

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (nums[n] == 0) {
            nums[n] = fib(n - 1) + fib(n - 2);
        }
        return nums[n];
    }
}