package tag.DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return bt(s, t, 0, 0);
    }

    int[][] cache;

    int bt(String s, String t, int i1, int i2) {
        if (i2 == t.length()) {
            return 1;
        }
        if (i1 == s.length()) {
            return 0;
        }
        if (cache[i1][i2] != -1) return cache[i1][i2];
        int way = 0;
        if (s.charAt(i1) == t.charAt(i2)) {
            way += bt(s, t, i1 + 1, i2 + 1);
        }
        way += bt(s, t, i1 + 1, i2);
        cache[i1][i2] = way;
        return way;
    }
}
