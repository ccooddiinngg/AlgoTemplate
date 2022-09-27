package tag.DynamicProgramming;

public class BestTimeToBuyAndSellStockII {
    int max = 0x3f3f3f3f;

    public int maxProfit(int[] prices) {
        int m = prices.length;
        cache = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                cache[i][j] = max;
            }
        }
        return bt(prices, 0, 0);
    }

    int[][] cache;

    int bt(int[] prices, int day, int has) {
        if (day == prices.length) {
            return 0;
        }
        if (cache[day][has] != max) return cache[day][has];
        int hold = bt(prices, day + 1, has);
        int act = 0;
        if (has == 1) {
            act = prices[day] + bt(prices, day + 1, 0);
        } else {
            act = -prices[day] + bt(prices, day + 1, 1);
        }
        int max = Math.max(hold, act);
        cache[day][has] = max;
        return max;
    }

    /**/
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
