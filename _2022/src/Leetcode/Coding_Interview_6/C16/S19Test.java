package Leetcode.Coding_Interview_6.C16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S19Test {
    S19 s19 = new S19();

    @Test
    void test() {
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        System.out.println(Arrays.toString(s19.pondSizes(land)));
    }

}