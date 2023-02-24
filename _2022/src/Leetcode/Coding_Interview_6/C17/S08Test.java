package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

class S08Test {
    @Test
    void test() {
        S08 s08 = new S08();
        int[] h = {8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773};
        int[] w = {9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340};
        System.out.println(s08.bestSeqAtIndex(h, w));
    }

}