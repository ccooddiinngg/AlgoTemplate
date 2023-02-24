package Leetcode.Coding_Interview_6.C01;

public class S07 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                swap(matrix, i, j, i, m - 1 - j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                swap(matrix, i, j, m - 1 - j, m - 1 - i);
            }
        }
    }

    public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int t = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = t;
    }
}
