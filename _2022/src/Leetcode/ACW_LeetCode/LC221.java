package Leetcode.ACW_LeetCode;

public class LC221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    right[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        int[][] bottom = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1) {
                    bottom[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        bottom[i][j] = bottom[i + 1][j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                while (i + k < m && j + k < n && right[i + k][j] > k && bottom[i][j + k] > k) {
                    k++;
                }
                max = Math.max(max, k);
            }
        }
        return max * max;
    }
}
