package Leetcode.ACW_LeetCode;

public class LC213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return helper(nums, n);
    }

    int helper(int[] nums, int n) {
        //from 0 -> n - 2
        int[][] dp1 = new int[n][2];
        dp1[0][1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
            dp1[i][1] = dp1[i - 1][0] + nums[i % n];
        }
        //from 1 -> n - 1
        int[][] dp0 = new int[n * 2][2];
        for (int i = 1; i < n; i++) {
            dp0[i][0] = Math.max(dp0[i - 1][0], dp0[i - 1][1]);
            dp0[i][1] = dp0[i - 1][0] + nums[i % n];
        }
        return Math.max(Math.max(dp1[n - 2][0], dp1[n - 2][1]), Math.max(dp0[n - 1][0], dp0[n - 1][1]));
    }
}
