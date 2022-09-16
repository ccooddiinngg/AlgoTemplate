package tag.DynamicProgramming;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int m = nums.length;
        //[len,count]
        int[][] dp = new int[m][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < m; i++) {
            int max = 1;
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] + 1 > max) {
                        max = dp[j][0] + 1;
                        count = dp[j][1];
                    } else if (dp[j][0] + 1 == max) {
                        count += dp[j][1];
                    }
                }
            }
            dp[i][0] = max;
            dp[i][1] = count;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < m; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
                count = dp[i][1];
            } else if (dp[i][0] == max) {
                count += dp[i][1];
            }
        }
        return count;
    }
}
