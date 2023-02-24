package Leetcode.Coding_Interview_6.C10;

import org.junit.jupiter.api.Test;

class S11Test {
    @Test
    void test() {
        S11a s11a = new S11a();
        int[] nums = {3, 1, 2};
        s11a.wiggleSort(nums);
        System.out.println(s11a.list);
    }

}