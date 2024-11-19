class Solution {
    public int solution(int[][] sizes) {
        int minX = 0, minY = 0;
        for (int i=0;i<sizes.length;i++) {
            int curX = sizes[i][0];
            int curY = sizes[i][1];
            minX = Math.max(minX, Math.min(curX, curY));
            minY = Math.max(minY, Math.max(curX, curY));
        }
        return minX * minY;
    }
}