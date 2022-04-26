class Solution {
    public int climbStairs(int n) {
        int[] dp = {2, 1};
        for (int i = 3; i <= n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }
        return dp[n % 2];
    }
}