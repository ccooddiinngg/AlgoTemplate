package Leetcode.Offer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class O44 {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        int numberOfDigits = 0;
        int count = 0;
        int pre = 0;
        while (count < n) {
            numberOfDigits++;
            pre = count;
            count += 9 * Math.pow(10, numberOfDigits - 1) * numberOfDigits;
        }
        int number = (n - pre - 1) / numberOfDigits + (int) Math.pow(10, numberOfDigits - 1);
        int delta = (n - pre - 1) % numberOfDigits;
        return getDelta(number, delta);
    }

    int getDelta(int number, int delta) {
        return String.valueOf(number).charAt(delta) - '0';
    }

    public int findNthDigit1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 333, 100, 435, 833})
    void test(int n) {

        System.out.println(findNthDigit(n));
        System.out.println(findNthDigit1(n));
    }
}
