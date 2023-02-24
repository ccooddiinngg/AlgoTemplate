package Leetcode.ACW_LeetCode;

public class LC123 {
     public int maxProfit(int[] prices) {
         int count = 4;
         return bt(prices, 0, false, count);
     }

     int bt(int[] p, int day, boolean hold, int count) {
          if (count == 0 || day == p.length) return 0;
          int wait = bt(p, day + 1, hold, count);
          int act = 0;
          if (hold) {
              act = bt(p, day + 1, false, count - 1) + p[day];
          }else {
              act = bt(p, day + 1, true, count - 1) - p[day];
          }
          return Math.max(wait, act);
     }

    public int maxProfitDP(int[] prices) {
        int count = 4;
        int m = prices.length;
        int[][][] dp = new int[m + 1][2][count + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= count; k++) {
                    int wait = dp[i + 1][j][k];
                    int act = 0;
                    if (j == 1) {
                        act = dp[i + 1][0][k - 1] + prices[i];
                    }else {
                        act = dp[i + 1][1][k - 1] - prices[i];
                    }
                    dp[i][j][k] = Math.max(wait, act);
                }
            }
        }
        return dp[0][0][count];
    }
}
