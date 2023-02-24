package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC329 {
    int m;
    int n;
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, bt(matrix, i, j));
            }
        }
        return max;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int bt(int[][] matrix, int x, int y) {
        if (cache[x][y] != -1) return cache[x][y];
        int next = 0;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] > matrix[x][y]) {
                next = Math.max(next, bt(matrix, x1, y1));
            }
        }
        cache[x][y] = next + 1;
        return cache[x][y];
    }
}
