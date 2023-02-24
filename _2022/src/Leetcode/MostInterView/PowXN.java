package Leetcode.MostInterView;

import org.junit.jupiter.api.Test;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            //! prevent -n out of range
            return (1 / x) * myPow(1 / x, -(n + 1));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    @Test
    void test() {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
