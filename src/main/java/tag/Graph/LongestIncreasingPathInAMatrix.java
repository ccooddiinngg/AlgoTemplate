package tag.Graph;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m][n];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, bt(matrix, m, n, i, j));
            }
        }
        return max;
    }

    int[][] cache;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int bt(int[][] matrix, int m, int n, int x, int y) {
        if (cache[x][y] != -1) return cache[x][y];
        int next = 0;
        for (int[] d : dir) {
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] > matrix[x][y]) {
                next = Math.max(next, bt(matrix, m, n, x1, y1));
            }
        }
        cache[x][y] = next + 1;
        return next + 1;
    }
}
