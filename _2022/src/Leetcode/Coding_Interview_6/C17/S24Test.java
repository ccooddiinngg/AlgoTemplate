package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S24Test {
    S24 s24 = new S24();

    @Test
    void test() {
        int[][] matrix = {{-1, 0}, {0, -1}};
        System.out.println(Arrays.toString(s24.getMaxMatrix(matrix)));
    }

}