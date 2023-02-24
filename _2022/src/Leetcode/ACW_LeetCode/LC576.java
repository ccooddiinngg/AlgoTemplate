package Leetcode.ACW_LeetCode;

public class LC576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < maxMove + 1; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return bt(m, n, startRow, startColumn, maxMove);
    }

    Double mod = 1e9 + 7;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] cache;

    int bt(int m, int n, int x, int y, int rest) {
        if (x < 0 || x == m || y < 0 || y == n) {
            return 1;
        }
        if (rest == 0) return 0;
        if (cache[x][y][rest] != -1) return cache[x][y][rest];
        int next = 0;
        for (int i = 0; i < dir.length; i++) {
            next += bt(m, n, x + dir[i][0], y + dir[i][1], rest - 1);
            next %= mod;
        }
        cache[x][y][rest] = next;
        return next;
    }
}
