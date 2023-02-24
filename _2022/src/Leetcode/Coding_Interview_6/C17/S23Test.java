package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S23Test {
    S23 s23 = new S23();

    int[][] matrix = {
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 0, 1, 1, 1}};

    @Test
    void test() {
        int[][] matrix = {
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1}
        };
        System.out.println(Arrays.toString(s23.findSquare(this.matrix)));
    }


}