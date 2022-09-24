package tag.DynamicProgramming;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        cache = new int[s.length() + 1][p.length() + 1];
        return bt(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    int[][] cache;

    boolean bt(char[] c1, char[] c2, int i1, int i2) {
        if (i2 == c2.length) {
            return i1 == c1.length;
        }
        if (cache[i1][i2] != 0) return cache[i1][i2] == 1;
        boolean match = i1 < c1.length && (c1[i1] == c2[i2] || c2[i2] == '.');
        if (i2 < c2.length - 1 && c2[i2 + 1] == '*') {
            boolean b1 = (bt(c1, c2, i1, i2 + 2) || (match && bt(c1, c2, i1 + 1, i2)));
            cache[i1][i2] = b1 ? 1 : 2;
            return b1;
        }
        boolean b2 = match && bt(c1, c2, i1 + 1, i2 + 1);
        cache[i1][i2] = b2 ? 1 : 2;
        return b2;
    }
}
