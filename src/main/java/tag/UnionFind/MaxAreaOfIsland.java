package tag.UnionFind;

import java.util.Arrays;

public class MaxAreaOfIsland {
    int[] p;
    int[] size;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = i * n + j;
                p[num] = num;
                size[num] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 < m && grid[i + 1][j] == 1) union(i * n + j, (i + 1) * n + j);
                    if (j + 1 < n && grid[i][j + 1] == 1) union(i * n + j, i * n + j + 1);
                }
            }
        }
        int max = 0;
        System.out.println(Arrays.toString(size));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, size[find(i * n + j)]);
                }
            }
        }
        return max;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 != p2) {
            p[p1] = p2;
            size[p2] += size[p1];
        }
    }
}
