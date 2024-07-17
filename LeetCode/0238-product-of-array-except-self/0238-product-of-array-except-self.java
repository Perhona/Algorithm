class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums를 두 번 순회하면서 이전 요소의 곱을 구하고, 이후 요소의 곱을 바로 곱해준다.
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        int p = 1; // 이전까지의 곱을 저장할 변수
        for (int i = 0; i < nums.length; i++) {
            // 이전까지의 곱 배열에 저장
            output[i] = p;
            // 이전까지의 곱 업데이트
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 2 개의 배열을 사용하지 않고 즉시 곱함
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }
}