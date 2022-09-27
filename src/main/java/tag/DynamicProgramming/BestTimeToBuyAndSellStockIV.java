package tag.DynamicProgramming;

public class BestTimeToBuyAndSellStockIV {
    int max = 0x3f3f3f3f;

    public int maxProfit(int k, int[] prices) {
        int m = prices.length;
        cache = new int[m][2][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                for (int p = 0; p < k + 1; p++) {
                    cache[i][j][p] = max;
                }
            }
        }
        return bt(prices, 0, 0, k);
    }

    int[][][] cache;

    int bt(int[] prices, int day, int has, int count) {
        if (day == prices.length || count == 0) {
            return 0;
        }
        if (cache[day][has][count] != max) return cache[day][has][count];
        int hold = bt(prices, day + 1, has, count);
        int act = 0;
        if (has == 1) {
            act = prices[day] + bt(prices, day + 1, 0, count - 1);
        } else {
            act = -prices[day] + bt(prices, day + 1, 1, count);
        }
        int max = Math.max(hold, act);
        cache[day][has][count] = max;
        return max;
    }
}
