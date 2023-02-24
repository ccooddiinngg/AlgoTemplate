package Leetcode.Coding_Interview_6.C01;

public class S08 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] copy = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    copy[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j]) {
                    for (int i1 = 0; i1 < m; i1++) {
                        matrix[i1][j] = 0;
                    }
                    for (int j1 = 0; j1 < n; j1++) {
                        matrix[i][j1] = 0;
                    }
                }
            }
        }
    }
}
