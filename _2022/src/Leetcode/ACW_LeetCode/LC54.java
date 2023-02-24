package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int i1 = 0;
        int j1 = 0;
        int i2 = m - 1;
        int j2 = n - 1;
        while (i1 <= i2 && j1 <= j2) {
            square(matrix, m, n, i1, j1, i2, j2, list);
            i1++;
            j1++;
            i2--;
            j2--;
        }
        return list;
    }

    void square(int[][] matrix, int m, int n, int i1, int j1, int i2, int j2, List<Integer> list) {
        for (int j = j1; j <= j2; j++) {
            list.add(matrix[i1][j]);
        }
        for (int i = i1 + 1; i <= i2; i++) {
            list.add(matrix[i][j2]);
        }
        if (i2 > i1) {
            for (int j = j2 - 1; j >= j1; j--) {
                list.add(matrix[i2][j]);
            }
        }
        if (j2 > j1) {
            for (int i = i2 - 1; i > i1; i--) {
                list.add(matrix[i][j1]);
            }
        }
    }
}
