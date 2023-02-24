package Leetcode.ACW_LeetCode;

public class LC486a {
    public boolean PredictTheWinner(int[] nums) {
        return bt(nums, 0, nums.length - 1) >= 0;
    }

    int bt(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int left = nums[l] - bt(nums, l + 1, r);
        int right = nums[r] - bt(nums, l, r - 1);
        return Math.max(left, right);
    }

    public boolean PredictTheWinnerDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
