package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class LC214 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        if (isPal(sb)) return sb.toString();
        for (int i = n - 1; i >= 0; i--) {
            sb.insert(n - 1 - i, s.charAt(i));
            if (isPal(sb)) {
                break;
            }
        }
        return sb.toString();
    }

    boolean isPal(StringBuilder sb) {
        int n = sb.length();
        int mid = n / 2;

        int i = mid - 1;
        int j = n % 2 == 0 ? mid : mid + 1;
        while (i >= 0 && sb.charAt(i) == sb.charAt(j)) {
            i--;
            j++;
        }
        return i == -1;
    }

    @Test
    void test() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            char r = (char) ('a' + (int) (26 * Math.random()));
            sb.append(r);
        }
        System.out.println(shortestPalindrome(sb.toString()));
    }
}
