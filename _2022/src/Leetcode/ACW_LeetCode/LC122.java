package Leetcode.ACW_LeetCode;

public class LC122 {
     public int maxProfit(int[] prices) {
         return bt(prices, 0, false);
     }

     int bt(int[] p, int day, boolean hold) {
         if (day == p.length) return 0;
         int wait = bt(p, day + 1, hold);
         int act = 0;
         if (hold) {
             act = bt(p, day + 1, false) + p[day];
         }else {
             act = bt(p, day + 1, true) - p[day];
         }
         return Math.max(wait, act);
     }

    public int maxProfitDP(int[] prices) {
        int m = prices.length;
        int[][] dp = new int[m + 1][2];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int wait = dp[i + 1][j];
                int act = 0;
                if (j == 1) {
                    act = dp[i + 1][0] + prices[i];
                }else {
                    act = dp[i + 1][1] - prices[i];
                }
                dp[i][j] = Math.max(wait, act);
            }
        }
        return dp[0][0];
    }
}
