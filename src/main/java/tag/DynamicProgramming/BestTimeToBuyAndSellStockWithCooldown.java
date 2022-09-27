package tag.DynamicProgramming;

public class BestTimeToBuyAndSellStockWithCooldown {
    int max = 0x3f3f3f3f;

    public int maxProfit(int[] prices) {
        int m = prices.length;
        cache = new int[m][2][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    cache[i][j][k] = max;
                }
            }
        }
        return bt(prices, 0, 0, 0);
    }

    int[][][] cache;

    int bt(int[] prices, int day, int has, int cd) {
        if (day == prices.length) {
            return 0;
        }
        if (cache[day][has][cd] != max) return cache[day][has][cd];
        int wait = bt(prices, day + 1, has, 0);
        int act = 0;
        if (has == 1) {
            act = prices[day] + bt(prices, day + 1, 0, 1);
        } else if (cd == 0) {
            act = -prices[day] + bt(prices, day + 1, 1, 0);
        }
        int pro = Math.max(wait, act);
        cache[day][has][cd] = pro;
        return pro;
    }
}
