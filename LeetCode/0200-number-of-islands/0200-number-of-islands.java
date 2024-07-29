class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        // 그리드 전체 순회
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 육지('1')를 발견한 경우 상하좌우로 깊이우선탐색
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        // 현재 위치가 그리드 밖이거나, 물('0')인 경우 탐색 종료
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        // 다시 탐색하지 않도록 방문한 지점은 물('0')로 변경
        grid[i][j] = '0';

        // 상하좌우 재귀 DFS
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}