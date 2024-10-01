class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 오른쪽 상단에서 시작
        int row = 0;
        int col = matrix[0].length - 1;

        // 행렬의 범위를 벗어나지 않도록 탐색
        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            } else if (current > target) {
                col--; // 현재 값이 target보다 크면 왼쪽으로 이동
            } else {
                row++; // 현재 값이 target보다 작으면 아래로 이동
            }
        }

        return false; // target을 찾지 못했으면 false 반환
    }
}