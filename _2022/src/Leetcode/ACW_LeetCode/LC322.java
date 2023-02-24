package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC322 {
    int max = 0x3f3f3f3f;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
