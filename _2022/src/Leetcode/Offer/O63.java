package Leetcode.Offer;

public class O63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            if (prices[i] < low) low = prices[i];
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[n][0] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][1] - prices[i]);
                }
            }
        }
        return dp[0][0];
    }

    //brute force
    public int maxProfit2(int[] prices) {
        return bt(prices, 0, false);
    }

    public int bt(int[] prices, int day, boolean has) {
        if (day == prices.length) return 0;
        int wait = bt(prices, day + 1, has);
        int act = 0;
        if (has) {
            act = bt(prices, prices.length, false) + prices[day];
        } else {
            act = bt(prices, day + 1, true) - prices[day];
        }
        return Math.max(wait, act);
    }
}
