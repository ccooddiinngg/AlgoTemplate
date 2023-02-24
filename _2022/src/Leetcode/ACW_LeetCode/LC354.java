package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int idx = indexOf(dp, envelopes[i][1]);
            dp[idx] = envelopes[i][1];
        }
        return indexOf(dp, Integer.MAX_VALUE);
    }

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

    @Test
    void test() {
        int[][] envelopes = {{30, 50}, {12, 2}, {3, 4}, {12, 15}};
        System.out.println(maxEnvelopes(envelopes));
    }
}
