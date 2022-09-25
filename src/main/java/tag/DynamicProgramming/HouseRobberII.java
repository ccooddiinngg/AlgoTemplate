package tag.DynamicProgramming;

public class HouseRobberII {
    public int rob(int[] nums) {
        int m = nums.length;
        if (m == 1) return nums[0];
        int max = 0;
        int[][] dp = new int[m][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < m - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        max = Math.max(dp[m - 2][0], dp[m - 2][1]);
        dp = new int[m][2];
        dp[1][1] = nums[1];
        for (int i = 2; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        max = Math.max(max, Math.max(dp[m - 1][0], dp[m - 1][1]));
        return max;
    }
}
