package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class O56_1 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lowBit = xor & -xor;
        int bits = 0;
        while (lowBit > 0) {
            lowBit >>= 1;
            bits++;
        }
        bits--;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (((num >> bits) & 1) == 1) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    @Test
    void test() {
        int[] nums = {1, 2, 5, 2};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
