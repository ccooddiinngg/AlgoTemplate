package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC476 {
    public int findComplement(int num) {
        int bit = 30;
        while ((num >> bit & 1) == 0) {
            bit--;
        }
        return ~num << (31 - bit) >>> (31 - bit);
    }

    @Test
    void test() {
        int num = 1;
        System.out.println(findComplement(num));
    }
}
