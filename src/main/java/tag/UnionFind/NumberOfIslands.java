package tag.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    int[] p;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = i * n + j;
                p[num] = num;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1') union(i * n + j, (i + 1) * n + j);
                    if (j + 1 < n && grid[i][j + 1] == '1') union(i * n + j, i * n + j + 1);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int p = find(i * n + j);
                    set.add(p);
                }
            }
        }
        return set.size();
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
        }
    }
}
