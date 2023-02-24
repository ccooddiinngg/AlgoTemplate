package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC115 {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for (int[] row : cache) Arrays.fill(row, -1);
        return bt(s.toCharArray(), 0, t.toCharArray(), 0, cache);
    }

    int bt(char[] s, int is, char[] t, int it, int[][] cache) {
        if (it == t.length) return 1;
        if (is == s.length) return 0;
        if (cache[is][it] != -1) return cache[is][it];
        int res = s[is] == t[it] ? bt(s, is + 1, t, it + 1, cache) + bt(s, is + 1, t, it, cache) : bt(s, is + 1, t, it, cache);
        cache[is][it] = res;
        return res;
    }

    //DP
    public int numDistinctDP(String s, String t) {
        char[] sc = s.toCharArray();
        int m = sc.length;
        char[] tc = t.toCharArray();
        int n = tc.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = sc[i] == tc[j] ? dp[i + 1][j + 1] + dp[i + 1][j] : dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    @Test
    void test() {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
}
