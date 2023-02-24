package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n + 2;
        int[] arr = new int[m];
        for (int i = 1; i < m - 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[m - 1] = 1;
        int[][] dp = new int[m][m];
        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[k] * arr[i] * arr[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][m - 1];
    }

    @Test
    void test() {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
