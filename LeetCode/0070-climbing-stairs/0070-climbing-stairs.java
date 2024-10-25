class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {   // 계단이 1개 or 2개일 때에는 오르는 방법이 n개와 같음
            return n;
        }

        int[] stairs = new int[46];
        stairs[1] = 1;
        stairs[2] = 2;

        // f(n) = f(n-1) + f(n-2): 계단이 n층일 때 오르는 방법의 갯수는 n-1개의 계단을 오르는 방법의 수 + n-2개의 계단을 오르는 방법의 수의 합과 같다.
        for (int i = 3; i <= n; i++) {
            if (stairs[i] == 0) {
                stairs[i] = stairs[i - 1] + stairs[i - 2];
            }
        }
        return stairs[n];
    }
}