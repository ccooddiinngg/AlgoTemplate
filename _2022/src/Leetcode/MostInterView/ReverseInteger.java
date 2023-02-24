package Leetcode.MostInterView;

import org.junit.jupiter.api.Test;

public class ReverseInteger {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int res = 0;
        while (x != 0) {
            if (res > max / 10 || (res == max / 10 && x > max % 10)) {
                return 0;
            }
            if (res < min / 10 || (res == min / 10 && x < min % 10)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    @Test
    void test() {
        int a = 123;
        System.out.println(reverse(a));
    }
}
