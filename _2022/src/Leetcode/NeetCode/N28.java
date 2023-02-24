package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//@@ go back to --> len = pre[len - 1]
public class N28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }

        if (n > m) {
            return -1;
        }

        char[] pat = needle.toCharArray();
        int[] pre = kmp(pat);
        char[] source = haystack.toCharArray();
        int i = 0;
        int j = 0;
        while (i < m) {
            if (source[i] == pat[j]) {
                i++;
                j++;
                if (j == n) {
                    return i - j;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = pre[j - 1];
                }
            }
        }
        return -1;
    }

    public int[] kmp(char[] chars) {
        int m = chars.length;
        int[] res = new int[m];
        int i = 1;
        int len = 0;
        while (i < m) {
            if (chars[i] == chars[len]) {
                res[i++] = ++len;
            } else {
                if (len == 0) {
                    res[i++] = 0;
                } else {
                    len = res[len - 1];
                }
            }
        }
        return res;
    }

    @Test
    void test() {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    @Test
    void testKMP() {
        String pat = "ababc";
        System.out.println(Arrays.toString(kmp(pat.toCharArray())));
    }
}
