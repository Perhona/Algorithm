class Solution {
    public int solution(int[] money) {
                int[][] dp = new int[2][money.length]; // 2차원 배열을 사용해 첫번째 집 도둑질 여부 구분
        // 첫번째 집을 털지 않는 경우
        dp[0][0] = 0;   // 첫번째 집은 털지 않음
        dp[0][1] = money[1];

        // 첫번째 집을 터는 경우
        dp[1][0] = 0;
        dp[1][1] = 0;   // 두번째 집은 털 수 없음
        for (int i = 2; i < money.length; i++) {
            int current = money[i];
            dp[0][i] = Math.max(dp[0][i - 2] + current, dp[0][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 2] + current, dp[1][i - 1]);
        }
        return Math.max(dp[0][money.length - 1], dp[1][money.length - 2] + money[0]);
    }
}