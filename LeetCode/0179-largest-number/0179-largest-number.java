class Solution {
    public String largestNumber(int[] nums) {   // 18ms
        // 두번째 수부터 앞의 수와 비교하며 가장 큰 수를 앞으로 보낸다.
        for (int i = 1; i < nums.length; i++) {
            int b = nums[i];
            int idx = i;
            while (idx - 1 >= 0) {
                int a = nums[idx - 1];
                if (toSwap(a, b)) {
                    int temp = a;
                    nums[idx - 1] = b;
                    nums[idx] = temp;
                }
                idx--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(n);
        }
        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }

    private boolean toSwap(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        return (aStr + bStr).compareTo(bStr + aStr) < 0;
//        return Long.parseLong(aStr + bStr) < Long.parseLong(bStr + aStr);
    }
}