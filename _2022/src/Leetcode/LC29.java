package Leetcode;

import org.junit.jupiter.api.Test;

public class LC29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long dd = (dividend < 0) ? -(long) dividend : (long) dividend;
        long dr = (divisor < 0) ? -(long) divisor : (long) divisor;
        return sign * (int) helper(dd, dr);
    }

    //用long是因为 d+d 可能溢出
    long helper(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long d = divisor;
        long res = 1;
        while ((d + d) <= dividend) {
            d += d;
            res += res;
        }
        return res + helper(dividend - d, divisor);
    }

    @Test
    void test() {
        int dividend = Integer.MAX_VALUE;
        int divisor = 1;
        System.out.println(divide(dividend, divisor));
    }
}
