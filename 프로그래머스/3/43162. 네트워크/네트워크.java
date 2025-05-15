class Solution {
    static boolean[] visited;
        public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        /* 각 컴퓨터 순회 */
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int i, int[][] computers, int n) {
        visited[i] = true;
        /* 연결된 컴퓨터 탐색 */
        for (int j = 0; j < n; j++) {
            if (computers[i][j] != 0 && !visited[j]) {
                dfs(j, computers, n);
            }
        }
    }
}