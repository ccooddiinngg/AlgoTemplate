package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LC166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean pos = (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);

        long num = Math.abs((long) numerator);
        //! Math.abs(denominator); if denominator == Integer.MIN_VALUE, den is still negative.
        long den = Math.abs((long) denominator);

        StringBuilder sb = new StringBuilder();
        if (!pos) sb.append("-");
        long whole = num / den;
        sb.append(whole);
        if (num % den == 0) {
            return sb.toString();
        }
        sb.append(".");
        long left = num % den;
        Map<Long, Integer> map = new HashMap<>();

        while (left != 0) {
            if (map.containsKey(left)) {
                sb.insert(map.get(left), "(");
                sb.append(")");
                break;
            }
            map.put(left, sb.length());

            left *= 10;
            sb.append(left / den);
            left %= den;

        }
        return sb.toString();
    }

    @Test
    void test() {
        int num = -1;
        int den = Integer.MIN_VALUE;
        System.out.println(fractionToDecimal(num, den));
    }
}
