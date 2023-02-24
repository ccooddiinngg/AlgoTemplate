package Leetcode.ACW_LeetCode;

public class LC883 {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = 0;
        for (int i = 0; i < m; i++) {
            n = Math.max(n, grid[i].length);
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                matrix[i][j] = grid[i][j];
            }
        }

        int xz = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, matrix[i][j]);
            }
            xz += max;
        }

        int xy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    xy++;
                }
            }
        }

        int yz = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            yz += max;
        }

        return xz + xy + yz;
    }
}
