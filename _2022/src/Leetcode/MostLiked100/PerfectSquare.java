package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    @Test
    void test() {
        int n = 100;
        for (int i = 1; i < n + 1; i++) {
            System.out.println(numSquares(i));
        }

    }
}
