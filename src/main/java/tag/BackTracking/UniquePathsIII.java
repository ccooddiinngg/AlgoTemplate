package tag.BackTracking;

//TODO bit manipulation
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int rest = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) rest++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return bt(grid, i, j, rest, new boolean[grid.length][grid[0].length]);
                }
            }
        }
        return -1;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int bt(int[][] grid, int x, int y, int rest, boolean[][] visited) {
        if (rest < -1) return 0;
        if (grid[x][y] == 2) {
            if (rest == -1) {
                return 1;
            }
            return 0;
        }
        visited[x][y] = true;
        int way = 0;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] != -1 && !visited[x1][y1]) {
                way += bt(grid, x1, y1, rest - 1, visited);
            }
        }
        visited[x][y] = false;
        return way;
    }
}
