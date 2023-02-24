package Leetcode.NeetCode;

public class N746 {
    public int minCostClimbingStairs(int[] cost) {
        int m = cost.length;
        int[] dp = new int[m + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
