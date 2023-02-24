package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC125 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j--;
            // System.out.println(i + " " + j);
            if (i < j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
                i++;
                j--;
            }
        }
        return true;
    }

    @Test
    void test() {
        String s = "OP";
        System.out.println(isPalindrome(s));
    }
}
