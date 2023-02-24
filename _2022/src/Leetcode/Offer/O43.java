package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class O43 {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len == 1) return n >= 1 ? 1 : 0;
        String[] strs = s.split("");
        int[] d = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {
                if (d[i] > 1) {
                    count += powOf10(len - 1 - i);
                } else if (d[i] == 1) {
                    count += getRight(s, i) + 1;
                }
            } else if (i == len - 1) {
                if (d[i] >= 1) {
                    count += getLeft(s, i) + 1;
                } else {
                    count += getLeft(s, i);
                }
            } else {
                if (d[i] > 1) {
                    count += (getLeft(s, i) + 1) * powOf10(len - 1 - i);
                } else if (d[i] == 1) {
                    count += getLeft(s, i) * powOf10(len - 1 - i) + getRight(s, i) + 1;
                } else {
                    count += getLeft(s, i) * powOf10(len - 1 - i);
                }
            }
        }
        return count;
    }

    int powOf10(int x) {
        return (int) Math.pow(10, x);
    }

    //idx (1 -> len - 1)
    int getLeft(String s, int idx) {
        return Integer.parseInt(s.substring(0, idx));
    }

    //idx (0 -> len - 2)
    int getRight(String s, int idx) {
        return Integer.parseInt(s.substring(idx + 1, s.length()));
    }

    @Test
    void test() {
        int n = 103;
        System.out.println(countDigitOne(n));
    }
}
