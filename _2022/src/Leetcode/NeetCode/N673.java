package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;


//@@ dp[0]: len dp[1]: count
public class N673 {
    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < m; i++) {
            int count = 1;
            int len = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] == len) {
                        count += dp[j][1];
                    }
                    if (dp[j][0] > len) {
                        len = dp[j][0];
                        count = dp[j][1];
                    }
                }
            }
            dp[i][0] = len + 1;
            dp[i][1] = count;
        }

        int max = 1;
        int count = 1;
        for (int i = 1; i < m; i++) {
            if (dp[i][0] == max) {
                count += dp[i][1];
            }
            if (dp[i][0] > max) {
                max = dp[i][0];
                count = dp[i][1];
            }
        }
        return count;
    }

    @Test
    void test() {
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}
