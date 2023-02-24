package Leetcode.Offer;

public class O19 {
    public boolean isMatch(String s, String p) {
        return find(s, p, 0, 0, new int[s.length() + 1][p.length() + 1]);
    }

    boolean find(String s, String p, int is, int ip, int[][] cache) {
        if (ip == p.length()) return is == s.length();

        if (cache[is][ip] != 0) return cache[is][ip] == 1;

        boolean match = (is < s.length() && ip < p.length()) && (p.charAt(ip) == '.' || s.charAt(is) == p.charAt(ip));
        if (ip < p.length() - 1 && p.charAt(ip + 1) == '*') {
            match = (match && find(s, p, is + 1, ip, cache)) || (match && find(s, p, is + 1, ip + 2, cache)) || find(s, p, is, ip + 2, cache);
        } else {
            match = match && find(s, p, is + 1, ip + 1, cache);
        }

        cache[is][ip] = match ? 1 : 2;
        return match;
    }
}
