package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int m = nums.length;
        int n = sum / 2;
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j - nums[i]];
                }
            }
        }

        return dp[0][n];
    }

    public boolean canPartitionPlus(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = dp.length - 1; j >= 1; j--) {
                if (j - num >= 0) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }

        return dp[sum];
    }

    @Test
    void test() {
        int[] nums = {3, 3, 3, 4, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartitionPlus(nums));
    }
}
