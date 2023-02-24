package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC87 {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        return bt(s1.toCharArray(), 0, s2.toCharArray(), 0, n, new int[n][n][n + 1]);
    }

    boolean bt(char[] chars1, int i1, char[] chars2, int i2, int len, int[][][] cache) {
        if (cache[i1][i2][len] != 0) return cache[i1][i2][len] == 1;
        if (len == 1) {
            return chars1[i1] == chars2[i2];
        }
        for (int i = 1; i < len; i++) {
            if( (bt(chars1, i1, chars2, i2, i, cache) && bt(chars1, i1 + i, chars2, i2 + i, len - i, cache))
                    || (bt(chars1, i1, chars2, i2 + (len - i), i, cache) && bt(chars1, i1 + i, chars2, i2, len - i, cache))) {
                cache[i1][i2][len] = 1;
                return true;
            }

        }
        cache[i1][i2][len] = 2;
        return false;
    }

    @Test
    void test() {
        String s1 = "abca";
        String s2 = "caba";
        System.out.println(isScramble(s1, s2));
    }
}
