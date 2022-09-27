package tag.DynamicProgramming;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        cache = new int[m][m][m + 1];
        return bt(s1, s2, 0, 0, m);
    }

    int[][][] cache;

    boolean bt(String s1, String s2, int l1, int l2, int len) {
        if (len == 1) {
            return s1.charAt(l1) == s2.charAt(l2);
        }
        if (cache[l1][l2][len] != 0) return cache[l1][l2][len] == 1;

        for (int i = 1; i < len; i++) {
            if ((bt(s1, s2, l1, l2, i) && bt(s1, s2, l1 + i, l2 + i, len - i))
                    || (bt(s1, s2, l1, l2 + len - i, i) && bt(s1, s2, l1 + i, l2, len - i))) {
                cache[l1][l2][len] = 1;
                return true;
            }
        }
        cache[l1][l2][len] = 2;
        return false;
    }
}
