package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC279 {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / i; i++) {
            list.add(i * i);
        }
        // return bt(list, n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int num : list) {
            for (int i = num; i < n + 1; i++) {
                dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }
        return dp[n];
    }

    int bt(List<Integer> nums, int rest) {
        if (rest == 0) return 0;
        int o = Integer.MAX_VALUE;
        for (int num : nums) {
            if (rest >= num) {
                int next = bt(nums, rest - num);
                if (next != Integer.MAX_VALUE) {
                    o = Math.min(o, next + 1);
                }
            }
        }
        return o;
    }
}
