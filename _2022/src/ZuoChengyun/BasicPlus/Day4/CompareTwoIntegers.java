package ZuoChengyun.BasicPlus.Day4;

import org.junit.jupiter.api.Test;

public class CompareTwoIntegers {

    public static int compareTwoIntegers(int a, int b) {
        int c = a - b;
        int signA = getSign(a);
        int signB = getSign(b);
        int signC = getSign(c);
        int sameSign = signA ^ signB;
        int diffSign = getFlip(sameSign);
        int returnA = sameSign * signC + diffSign * signA;
        int returnB = getFlip(returnA);
        return a * returnA + b * returnB;
    }

    private static int getFlip(int sign) {
        return sign ^ 1;
    }

    //正数返回1， 负数返回0
    private static int getSign(int c) {
        return getFlip(c >> 31 & 1);
    }


    @Test
    void test() {
        int a = -123;
        int b = -121;
        System.out.println(compareTwoIntegers(a, b));
    }
}
