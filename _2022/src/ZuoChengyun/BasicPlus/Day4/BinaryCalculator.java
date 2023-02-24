package ZuoChengyun.BasicPlus.Day4;

import org.junit.jupiter.api.Test;

public class BinaryCalculator {

    public static int add(int a, int b) {
        int x = a;
        int y = b;
        while (y != 0) {
            int t1 = x ^ y;
            int t2 = (x & y) << 1;
            x = t1;
            y = t2;
        }
        return x;
    }

    public static int subtract(int a, int b) {
        return add(a, getNegative(b));
    }

    private static int getNegative(int n) {
        return add(~n, 1);
    }

    public static int multiply(int a, int b) {
        int sum = 0;
        int x = a;
        int y = b;
        while (y != 0) {
            if ((y & 1) == 1) {
                sum = add(sum, x);
            }
            //>>> unsigned shift
            y = y >>> 1;
            x = x << 1;
        }
        return sum;
    }

    public static int divide(int a, int b) {
        int x = a < 0 ? getNegative(a) : a;
        int y = b < 0 ? getNegative(b) : b;

        int result = 0;
        for (int i = 31; i >= 0; i = subtract(i, 1)) {
            //! use >>> not >>
            if ((x >>> i) - y >= 0) {
                result |= 1 << i;
                x = subtract(x, y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? getNegative(result) : result;
    }

    @Test
    void test() {
        int a = -62;
        int b = -31;
        System.out.println(add(a, b));
        System.out.println(subtract(a, b));
        System.out.println(multiply(a, b));
        System.out.println(divide(a, b));

        //test
        int num = -1024;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        num >>>= 2;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;


    }
}
