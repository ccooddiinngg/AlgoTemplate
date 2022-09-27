package tag.DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioningII {
    int MAX = 0x3f3f3f3f;

    public int minCut(String s) {
        int m = s.length();
        int[] cache = new int[m];
        Arrays.fill(cache, -1);
        boolean[][] dp = new boolean[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
        return bt(s, 0, cache, dp) - 1;
    }

    int bt(String s, int idx, int[] cache, boolean[][] dp) {
        if (idx == s.length()) {
            return 0;
        }
        if (cache[idx] != -1) return cache[idx];
        int next = MAX;
        for (int i = 0; idx + i < s.length(); i++) {
            if (dp[idx][idx + i]) {
                next = Math.min(next, bt(s, idx + i + 1, cache, dp));
            }
        }
        cache[idx] = next + 1;
        return next + 1;
    }
}
