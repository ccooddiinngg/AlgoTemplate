package Leetcode.ACW_LeetCode;

public class LC5 {
    public String longestPalindrome(String s) {
        int max = 0;
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] res = find(s, i, i);
            if (res[1] - res[0] + 1 > max) {
                max = res[1] - res[0] + 1;
                ans = res;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int[] res = find(s, i, i + 1);
            if (res[1] - res[0] + 1 > max) {
                max = res[1] - res[0] + 1;
                ans = res;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    int[] find(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
    }
}