package Leetcode.Offer;

public class O10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        double mod = 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= mod;
        }
        return dp[n];
    }
}
