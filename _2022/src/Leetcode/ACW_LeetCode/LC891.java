package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC891 {
    public int sumSubseqWidths(int[] nums) {
        int mod = 1000000007;
        Arrays.sort(nums);
        int n = nums.length;
        long[] p2 = new long[n];
        p2[0] = 1;
        for (int i = 1; i < n; i++) {
            p2[i] = p2[i - 1] * 2;
            p2[i] %= mod;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long contribute = (p2[i] - p2[n - 1 - i]) * nums[i] % mod;
            sum += contribute;
            sum %= mod;
        }
        return (int) sum;
    }
}
