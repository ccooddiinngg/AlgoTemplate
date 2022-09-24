package tag.DynamicProgramming;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        cache = new int[s.length() + 1][p.length() + 1];
        return bt(s, p, 0, 0);
    }

    int[][] cache;

    boolean bt(String s, String p, int i1, int i2) {
        if (i2 == p.length()) {
            return i1 == s.length();
        }
        if (i1 > s.length()) return false;
        if (cache[i1][i2] != 0) return cache[i1][i2] == 1;
        if (p.charAt(i2) == '*') {
            boolean b1 = bt(s, p, i1, i2 + 1) || bt(s, p, i1 + 1, i2);
            cache[i1][i2] = b1 ? 1 : 2;
            return b1;
        }
        if (i1 < s.length() && (p.charAt(i2) == '?' || s.charAt(i1) == p.charAt(i2))) {
            boolean b2 = bt(s, p, i1 + 1, i2 + 1);
            cache[i1][i2] = b2 ? 1 : 2;
            return b2;
        }
        cache[i1][i2] = 2;
        return false;
    }
}
