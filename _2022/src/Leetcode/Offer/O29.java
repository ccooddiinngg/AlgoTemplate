package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        List<Integer> path = new ArrayList<>();
        int i1 = 0;
        int j1 = 0;
        int i2 = m - 1;
        int j2 = n - 1;
        while (i1 <= i2 && j1 <= j2) {
            find(matrix, i1, j1, i2, j2, path);
            i1++;
            j1++;
            i2--;
            j2--;
        }
        // System.out.println(path);
        int[] res = new int[m * n];
        for (int i = 0; i < res.length; i++) {
            res[i] = path.get(i);
        }
        return res;
    }

    void find(int[][] matrix, int i1, int j1, int i2, int j2, List<Integer> path) {
        for (int j = j1; j <= j2; j++) {
            path.add(matrix[i1][j]);
        }
        for (int i = i1 + 1; i <= i2; i++) {
            path.add(matrix[i][j2]);
        }

        for (int j = j2 - 1; j >= j1; j--) {
            path.add(matrix[i2][j]);
        }


        for (int i = i2 - 1; i > i1; i--) {
            path.add(matrix[i][j1]);
        }

    }

    @Test
    void test() {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
