package Leetcode.Coding_Interview_6.C17;

import java.util.Arrays;

public class S24 {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[4];
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i1 = 0; i1 < m; i1++) {
            Arrays.fill(dp, 0);
            for (int i2 = i1; i2 < m; i2++) {
                int sum = 0;
                int j1 = 0;
                for (int j2 = 0; j2 < n; j2++) {
                    dp[j2] += matrix[i2][j2];
                    if (sum > 0) {
                        sum += dp[j2];
                    } else {
                        sum = dp[j2];
                        j1 = j2;
                    }
                    if (sum > max) {
                        max = sum;
                        res[0] = i1;
                        res[1] = j1;
                        res[2] = i2;
                        res[3] = j2;
                    }
                }
            }
        }
        return res;
    }
}
