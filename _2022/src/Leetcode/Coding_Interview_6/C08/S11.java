package Leetcode.Coding_Interview_6.C08;

public class S11 {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int j = c; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - c]) % mod;
            }
        }
        return dp[n];
    }
}
