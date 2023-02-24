package Leetcode.Coding_Interview_6.C10;

import org.junit.jupiter.api.Test;

class S03Test {
    S03 s03 = new S03();

    @Test
    void test() {
        int[] nums = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        int res = s03.search(nums, target);
        System.out.println(res);
    }
}