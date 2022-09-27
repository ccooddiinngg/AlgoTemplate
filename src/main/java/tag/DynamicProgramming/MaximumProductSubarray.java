package tag.DynamicProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]), nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int[] v : dp) {
            max = Math.max(max, v[1]);
        }
        return max;
    }
}
