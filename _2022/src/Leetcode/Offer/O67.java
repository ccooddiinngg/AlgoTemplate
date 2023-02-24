package Leetcode.Offer;

import org.junit.jupiter.api.Test;

public class O67 {
    public int strToInt(String str) {
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') i++;
        boolean isNegative = false;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
        long num = 0;
        while (i < n && (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' < 10)) {
            num = num * 10 + str.charAt(i) - '0';
            if (num >= Integer.MAX_VALUE && !isNegative) {
                return Integer.MAX_VALUE;
            }
            if (num > Integer.MAX_VALUE && isNegative) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return isNegative ? -(int) num : (int) num;
    }

    @Test
    void test() {
        String s = " -42";
        System.out.println(strToInt(s));
    }
}
