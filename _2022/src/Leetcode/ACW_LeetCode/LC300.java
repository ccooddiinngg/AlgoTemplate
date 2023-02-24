package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int num : nums) {
            int idx = indexOf(dp, num);
            dp[idx] = num;
        }
        return indexOf(dp, Integer.MAX_VALUE);
    }

    //dp: [min, a, b, c..., max];
    int indexOf(int[] dp, int num) {
        int i = 0;
        int j = dp.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (dp[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
