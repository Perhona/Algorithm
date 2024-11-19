class Solution {
    public int solution(int[][] sizes) {
        for (int i=0;i<sizes.length;i++) {
            int curX = sizes[i][0];
            int curY = sizes[i][1];
            if (curX > curY) {
                sizes[i][0] = curY;
                sizes[i][1] = curX;
            }
        }
        
        int minX = 0, minY = 0;
        for (int i=0;i<sizes.length;i++) {
            int curX = sizes[i][0];
            int curY = sizes[i][1];
            minX = Math.max(curX, minX);
            minY = Math.max(curY, minY);
        }
        
        return minX * minY;
    }
}