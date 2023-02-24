package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class O60 {
    public double[] dicesProbability(int n) {

        //dp[n][m] n: dice numbers, m: roll number. present how many chances
        int[][] dp = new int[n + 1][6 * n + 1];
        //if only one dice, total 6 numbers, each number has one chance
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < 6 * i + 1; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        double all = Math.pow(6, n);
        double[] res = new double[6 * n + 1 - n];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i + n] / all;
        }
        return res;
    }

    @Test
    void test() {
        int n = 1;
        System.out.println(Arrays.toString(dicesProbability(n)));
    }
}
