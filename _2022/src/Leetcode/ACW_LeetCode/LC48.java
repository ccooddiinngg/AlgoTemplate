package Leetcode.ACW_LeetCode;

public class LC48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        mirror1(matrix, n);
        mirror2(matrix, n);
    }

    void mirror1(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }

    void mirror2(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = t;
            }
        }
    }
}
