package Leetcode.Offer;

public class O46 {
    public int translateNum(int num) {
        return dfs(String.valueOf(num), 0);
    }

    int dfs(String s, int idx) {
        if (idx == s.length()) return 1;
        int count = dfs(s, idx + 1);
        if (idx < s.length() - 1 && (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) - '5' <= 0))) {
            count += dfs(s, idx + 2);
        }
        return count;
    }
}
