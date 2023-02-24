package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class N309 {
    //@@ TLE
    public int maxProfit(int[] prices) {
        return helper(prices, 0, 0, false);
    }

    public int helper(int[] prices, int index, int hold, boolean canSell) {
        if (index >= prices.length) {
            return 0;
        }

        if (!canSell) {
            return Math.max(helper(prices, index + 1, hold + prices[index], true), helper(prices, index + 1, hold, false));
        }

        int profit = prices[index] - hold;
        return Math.max(helper(prices, index + 1, hold, true), helper(prices, index + 2, 0, false) + profit);

    }

    //@@ Not efficient
    public int maxProfitDP(int[] prices) {
        int max = 0;
        for (int p : prices) {
            max = Math.max(max, p);
        }

        int[][] dp0 = new int[prices.length + 2][max + 1];
        int[][] dp1 = new int[prices.length + 2][max + 1];

        for (int i = dp0.length - 3; i >= 0; i--) {
            for (int j = dp0[0].length - 1; j >= 0; j--) {
                dp0[i][j] = Math.max(dp1[i + 1][prices[i]], dp0[i + 1][0]);
                dp1[i][j] = Math.max(dp1[i + 1][j], dp0[i + 2][0] + prices[i] - j);
            }
        }

        return dp0[0][0];
    }

    //@@ 3 States , each state represents the max profit after buy/sell/rest on each day
    public int maxProfitStateMachine(int[] prices) {
        int m = prices.length;
        int[] buy = new int[m];
        int[] sell = new int[m];
        int[] rest = new int[m];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < m; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = buy[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
        }

        return Math.max(buy[m - 1], Math.max(sell[m - 1], rest[m - 1]));
    }


    @Test
    void test() throws FileNotFoundException {
        int[] prices = TxtToIntArray.read("src/Leetcode.NeetCode/prices.txt");
//        System.out.println(Arrays.toString(prices));
        System.out.println(maxProfitDP(prices));
        System.out.println(maxProfitStateMachine(prices));
    }
}
