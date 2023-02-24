package ZuoChengyun.BasicPlus.Day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerOfTwo {

    public static boolean isPowerOfTwo1(int n) {
        return n == ((~n + 1) & n);
    }

    public static boolean isPowerOfTwo2(int n) {
        return ((n - 1) & n) == 0;
    }

    @Test
    void testIsPowerOfTwo() {
        int n = (int) Math.pow(2, 30) - 1;
        System.out.println(isPowerOfTwo1(n));
        assertEquals(isPowerOfTwo1(n), isPowerOfTwo2(n));
    }

    public static boolean isPowerOfFour(int n) {
        int x = 0b01010101010101010101010101010101;
        int y = 0x55555555;
        System.out.println(x);
        System.out.println(y);
        return (((~n + 1) & n) == n) && ((n & x) != 0);
    }

    @Test
    void testIsPowerOfFour() {
        int n = (int) Math.pow(4, 14);
        System.out.println(isPowerOfFour(n));
    }
}
