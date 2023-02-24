package Playground.Math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Math {
    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            //-INF + 1 可以保证不爆INT
            return 1 / (x * pow(x, -(n + 1)));
        }
        return n % 2 == 0 ? pow(x * x, n >> 1) : x * pow(x * x, n >> 1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Test
    void testPOW() {
        Assertions.assertEquals(Math.pow(2, 0), pow(2, 0));
        Assertions.assertEquals(Math.pow(2, 10), pow(2, 10));
        Assertions.assertEquals(Math.pow(2, 11), pow(2, 11));
        Assertions.assertEquals(Math.pow(2, 20), pow(2, 20));
        Assertions.assertEquals(Math.pow(1, Integer.MIN_VALUE), pow(1, Integer.MIN_VALUE));

    }

    @Test
    void testGCD() {
        Assertions.assertEquals(2, gcd(8, 6));
    }
}
