package Leetcode.ACW_LeetCode;

public class LC309 {
    public int maxProfit(int[] prices) {

        cache = new int[prices.length + 1][2][2];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (i == cache.length - 1) {
                        cache[i][j][k] = 0;
                    } else {
                        cache[i][j][k] = -1;
                    }
                }
            }
        }
        return bt(prices, 0, 0, 1);
    }

    int[][][] cache;

    int bt(int[] prices, int day, int hold, int canBuy) {
        if (day == prices.length) {
            return 0;
        }
        if (cache[day][hold][canBuy] != -1) return cache[day][hold][canBuy];
        int max = 0;
        int sell = 0;
        int buy = 0;
        int wait = 0;
        if (hold == 1) {
            sell = bt(prices, day + 1, 0, 0) + prices[day];
            wait = bt(prices, day + 1, 1, 0);
        } else {
            if (canBuy == 1) {
                buy = bt(prices, day + 1, 1, 0) - prices[day];
                wait = bt(prices, day + 1, 0, 1);
            } else {
                wait = bt(prices, day + 1, 0, 1);
            }
        }
        max = Math.max(Math.max(buy, sell), wait);
        cache[day][hold][canBuy] = max;
        return max;
    }
}
