package DP;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int m = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //以i为结尾的连续子串最小值
        int[] dp1 = new int[m];
        //以i为结尾的连续子串的最大值
        int[] dp2 = new int[m];
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        int sum = nums[0];
        boolean negative = nums[0] < 0;
        for (int i = 1; i < m; i++) {
            sum += nums[i];
            if (nums[i] >= 0) negative = false;
            dp1[i] = Math.min(nums[i], dp1[i - 1] + nums[i]);
            dp2[i] = Math.max(nums[i], dp2[i - 1] + nums[i]);
        }
        for (int v : dp1) {
            min = Math.min(min, v);
        }
        for (int v : dp2) {
            max = Math.max(max, v);
        }
        if (negative) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}
