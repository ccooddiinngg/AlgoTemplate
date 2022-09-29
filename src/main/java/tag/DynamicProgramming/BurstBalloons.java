package tag.DynamicProgramming;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;
        int[] copy = new int[m];
        copy[0] = 1;
        copy[m - 1] = 1;
        for (int i = 1; i < m - 1; i++) {
            copy[i] = nums[i - 1];
        }
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + copy[i] * copy[j] * copy[k]);
                }
            }
        }
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][m - 1];
    }
}
