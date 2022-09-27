package tag.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int idx = find(dp, nums[i]);
            dp[idx] = nums[i];
        }
        return find(dp, Integer.MAX_VALUE);
    }

    int find(int[] dp, int num) {
        int l = 0;
        int r = dp.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (dp[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
