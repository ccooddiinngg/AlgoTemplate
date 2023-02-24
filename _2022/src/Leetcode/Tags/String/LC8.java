package Leetcode.Tags.String;

public class LC8 {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        int sign = 1;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
        }
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        //! prevent int overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
            i++;
        }
        return sign * res;
    }
}
