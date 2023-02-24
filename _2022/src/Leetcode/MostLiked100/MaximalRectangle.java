package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int max = 0;
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    right[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    right[i][j] = matrix[i][j] == '1' ? 1 + right[i][j + 1] : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int size = findMaxSize(matrix, i, j, right);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    public int findMaxSize(char[][] matrix, int i, int j, int[][] right) {
        int max = 0;
        int i1 = i;
        int width = matrix[0].length;
        while (i1 < matrix.length && matrix[i1][j] == '1') {
            width = Math.min(width, right[i1][j]);
            int height = i1 + 1 - i;
            max = Math.max(max, width * height);
            i1++;
        }
        return max;
    }

    @Test
    void test() {
        char[][] matrix = {{'1', '1'}};
        System.out.println(maximalRectangle(matrix));
    }
}
