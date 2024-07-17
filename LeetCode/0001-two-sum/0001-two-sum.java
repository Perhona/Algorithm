class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 첫번 째 더할 값 배열 순회
        for(int i=0;i<nums.length;i++){
            // 두번째 더할 값 배열 순회
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}