package tag.DynamicProgramming;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m][2];
        //up
        dp[0][0] = 1;
        //down
        dp[0][1] = 1;
        //only compare with pre one
        for (int i = 1; i < m; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[m - 1][0], dp[m - 1][1]);
    }
}
