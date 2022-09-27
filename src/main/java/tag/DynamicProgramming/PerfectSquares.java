package tag.DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    int MAX = 0x3f3f3f3f;

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
