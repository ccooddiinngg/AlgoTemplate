package Leetcode.ACW_LeetCode;

public class LC188 {
    public int maxProfit(int k, int[] prices) {
        // return bt(prices, 0, false, k);
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int hold = 0; hold < 2; hold++) {
                    int wait = dp[i][j][hold] = dp[i + 1][j][hold];
                    int act = 0;
                    if (hold == 1) {
                        act = dp[i + 1][j - 1][0] + prices[i];
                    } else {
                        act = dp[i + 1][j][1] - prices[i];
                    }
                    dp[i][j][hold] = Math.max(wait, act);
                }
            }
        }
        return dp[0][k][0];
    }

    int bt(int[] p, int day, boolean hold, int k) {
        if (k == 0 || day == p.length) return 0;
        int wait = bt(p, day + 1, hold, k);
        int act = 0;
        if (hold) {
            act = bt(p, day + 1, false, k - 1) + p[day];
        } else {
            act = bt(p, day + 1, true, k) - p[day];
        }
        return Math.max(wait, act);
    }
}
