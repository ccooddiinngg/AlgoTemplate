package tag.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int MAX = 0x3f3f3f3f;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
