package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int bit = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((i & (i - 1)) == 0) {
                bit = i;
            }
            res[i] = res[i - bit] + 1;
        }
        return res;
    }

    @Test
    void test() {
        int n = 6000;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
