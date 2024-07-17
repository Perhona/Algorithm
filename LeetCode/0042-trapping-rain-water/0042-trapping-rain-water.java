class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }

        int totalWater = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        int leftMaxHeight = height[leftIdx];
        int rightMaxHeight = height[rightIdx];

        // 각 벽의 높이가 1 이상일 때, 벽의 높이가 작은 쪽의 높이를 기준으로 빗물이 고일 수 있다.
        while (leftIdx < rightIdx) {
            if (leftMaxHeight < rightMaxHeight) {
                leftIdx++;
                if (leftMaxHeight < height[leftIdx]) {
                    leftMaxHeight = height[leftIdx];
                } else {
                    totalWater += leftMaxHeight - height[leftIdx];
                }
            } else {
                rightIdx--;
                if (rightMaxHeight < height[rightIdx]){
                    rightMaxHeight = height[rightIdx];
                } else {
                    totalWater += rightMaxHeight - height[rightIdx];
                }
            }
        }
        return totalWater;
    }
}