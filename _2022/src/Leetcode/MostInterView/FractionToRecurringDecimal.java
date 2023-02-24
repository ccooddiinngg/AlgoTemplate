package Leetcode.MostInterView;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = Math.abs((long) numerator);
        long de = Math.abs((long) denominator);
        long whole = num / de;
        long left = num % de;
        StringBuilder buffer = new StringBuilder();
        String sign = (numerator >= 0 && denominator > 0) || (numerator <= 0 && denominator < 0) ? "" : "-";
        buffer.append(sign);
        buffer.append(String.valueOf(whole));
        if (left == 0) {
            return buffer.toString();
        }
        buffer.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(left, buffer.length());
        return helper(left, de, buffer, map);
    }

    public String helper(long numerator, long denominator, StringBuilder buffer, Map<Long, Integer> map) {
        if (numerator == 0) {
            return buffer.toString();
        }
        numerator *= 10;
        while (numerator < denominator) {
            buffer.append("0");
            numerator *= 10;
        }

        buffer.append(String.valueOf(numerator / denominator));
        numerator %= denominator;
        if (map.containsKey(numerator)) {
            buffer.insert(map.get(numerator), "(");
            buffer.append(")");
            return buffer.toString();
        }
        map.put(numerator, buffer.length());
        return helper(numerator, denominator, buffer, map);
    }

    @Test
    void test() {
        int numerator = 2;
        int denominator = 3;
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
