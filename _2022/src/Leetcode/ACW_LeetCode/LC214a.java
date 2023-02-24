package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC214a {
    public String shortestPalindrome(String s) {
        if (s.equals("")) return "";
        StringBuilder back = new StringBuilder(s).reverse();
        String str = s + "*" + back;
        int[] p = pre(str);

        return back.substring(0, back.length() - p[p.length - 1]) + s;
    }

    int[] pre(String s) {
        int[] p = new int[s.length()];
        int i = 1;
        int len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                p[i++] = ++len;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = p[len - 1];
                }
            }
        }
        return p;
    }

    @Test
    void test() {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
}
