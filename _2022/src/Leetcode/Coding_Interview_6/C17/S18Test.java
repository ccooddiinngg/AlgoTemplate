package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S18Test {
    S18 s18 = new S18();

    @Test
    void test() {
        int[] big = {878982, 143504, 268583, 394343, 849567, 257687, 352256, 35131, 663529, 543027};
        int[] small = {143504};
        System.out.println(Arrays.toString(s18.shortestSeq(big, small)));
    }

}