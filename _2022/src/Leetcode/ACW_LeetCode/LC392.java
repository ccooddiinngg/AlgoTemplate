package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m == 0) return true;
        if (n == 0) return false;
        int[][] dp = new int[n + 1][26];
        Arrays.fill(dp[n], n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int i = 0;
        int j = 0;
        while (i < m && j < n && dp[j][s.charAt(i) - 'a'] < n) {
            j = dp[j][s.charAt(i) - 'a'] + 1;
            i++;
        }
        return i == m;
    }
}
