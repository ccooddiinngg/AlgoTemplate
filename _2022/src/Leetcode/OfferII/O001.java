package Leetcode.OfferII;

import org.junit.jupiter.api.Test;

public class O001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        int res = 0;
        boolean positive = true;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            positive = false;
        }
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        while (a <= b) {
            a -= b;
            res++;
        }
        return positive ? res : -res;
    }

    @Test
    void test() {
        System.out.println(divide(Integer.MIN_VALUE, 2));
    }
}
