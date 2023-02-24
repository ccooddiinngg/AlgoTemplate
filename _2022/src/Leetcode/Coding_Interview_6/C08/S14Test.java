package Leetcode.Coding_Interview_6.C08;

import org.junit.jupiter.api.Test;

class S14Test {
    S14 s14 = new S14();

    @Test
    void test() {
        String s = "0&0&0&1^1|0";
//        String s = "1^0|1";
        int result = 1;
        System.out.println(s14.countEval(s, result));
    }

}