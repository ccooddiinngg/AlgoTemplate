package Leetcode;

public class LC459 {
    public static boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        int[] pre = new int[m];
        int i = 1;
        int len = 0;
        while (i < m) {
            if (s.charAt(i) == s.charAt(len)) {
                pre[i++] = ++len;
            } else {
                if (len == 0) {
                    pre[i++] = 0;
                } else {
                    len = pre[len - 1];
                }
            }
        }

        return pre[m - 1] != 0 && pre[m - 1] % (m - pre[m - 1]) == 0;
    }

    public static void main(String[] args) {
        String s = "abaabaa";
        System.out.println(repeatedSubstringPattern(s));
    }
}
