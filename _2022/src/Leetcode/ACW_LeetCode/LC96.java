package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC96 {
    public int numTrees(int n) {
        int[][] cache = new int[n + 1][n + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return bt(1, n, cache);
    }

    int bt(int l, int r, int[][] cache) {
        if (l >= r) return 1;
        if (cache[l][r] != -1) return cache[l][r];
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += bt(l, i - 1, cache) * bt(i + 1, r, cache);
        }
        cache[l][r] = res;
        return res;
    }
}
