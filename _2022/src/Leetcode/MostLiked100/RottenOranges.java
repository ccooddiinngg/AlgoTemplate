package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        boolean isEnd = false;
        int[][] pre = new int[grid.length][grid[0].length];
        int count = 0;
        while (!isEnd) {
            isEnd = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    pre[i][j] = grid[i][j];
                }
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (pre[i][j] == 2) {
                        if (canRot(grid, i, j)) {
                            isEnd = false;
                            rot(grid, i, j);
                        }
                    }
                }
            }

            if (!isEnd) {
                count++;
            }
        }
        return isDone(grid) ? count : -1;
    }

    public boolean canRot(int[][] grid, int i, int j) {
        return ((i - 1 >= 0 && grid[i - 1][j] == 1) ||
                (i + 1 < grid.length && grid[i + 1][j] == 1) ||
                (j - 1 >= 0 && grid[i][j - 1] == 1) ||
                (j + 1 < grid[0].length && grid[i][j + 1] == 1));
    }

    public void rot(int[][] grid, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == 1) grid[i - 1][j] = 2;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) grid[i + 1][j] = 2;
        if (j - 1 >= 0 && grid[i][j - 1] == 1) grid[i][j - 1] = 2;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) grid[i][j + 1] = 2;
    }

    public boolean isDone(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    @Test
    void test() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));

    }
}
