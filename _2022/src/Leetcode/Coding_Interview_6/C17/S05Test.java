package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S05Test {
    @Test
    void test() {
        S05 s05 = new S05();
        String[] s = {"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52"};
        System.out.println(Arrays.toString(s05.findLongestSubarray(s)));
    }

}