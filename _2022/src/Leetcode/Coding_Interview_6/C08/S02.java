package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S02 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        List<List<Integer>> path = new ArrayList<>();

        if (obstacleGrid[0][0] == 1) return res;
        dfs(obstacleGrid, m, n, path, 0, 0);
        return res;
    }

    boolean dfs(int[][] grid, int m, int n, List<List<Integer>> path, int x, int y) {
        if (x == m - 1 && y == n - 1) {
            path.add(Arrays.asList(x, y));
            res = new ArrayList<>(path);
            return true;
        }
        path.add(Arrays.asList(x, y));
        grid[x][y] = 1;
        if (x + 1 < m && grid[x + 1][y] == 0) {
            if (dfs(grid, m, n, path, x + 1, y)) return true;
        }
        if (y + 1 < n && grid[x][y + 1] == 0) {
            if (dfs(grid, m, n, path, x, y + 1)) return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
