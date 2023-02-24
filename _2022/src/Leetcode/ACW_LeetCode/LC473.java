package Leetcode.ACW_LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class LC473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        int max = sum / 4;
        Arrays.sort(matchsticks);
        return bt(matchsticks, matchsticks.length - 1, new int[4], max);
    }

    boolean bt(int[] matchsticks, int idx, int[] k, int max) {
        if (idx == -1) return true;
        for (int i = 0; i < k.length; i++) {
            if (k[i] + matchsticks[idx] <= max) {
                k[i] += matchsticks[idx];
                boolean next = bt(matchsticks, idx - 1, k, max);
                k[i] -= matchsticks[idx];
                if (next) {
                    return true;
                }
            }
        }
        return false;
    }
}
