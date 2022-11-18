[1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves/)
```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            bt(grid, i, 0);
            bt(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            bt(grid, 0, j);
            bt(grid, m - 1, j);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    void bt(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        bt(grid, x + 1, y);
        bt(grid, x - 1, y);
        bt(grid, x, y + 1);
        bt(grid, x, y - 1);
    }
}
```