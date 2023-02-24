package Leetcode.NeetCode;

public class N695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        if (i - 1 >= 0) {
            count += dfs(grid, i - 1, j);
        }
        if (i + 1 < grid.length) {
            count += dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0) {
            count += dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length) {
            count += dfs(grid, i, j + 1);
        }
        return count;
    }
}
