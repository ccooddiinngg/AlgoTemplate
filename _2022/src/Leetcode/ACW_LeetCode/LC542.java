package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542 {

    int[][] cache;
    int m;
    int n;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        cache = new int[m][n];
        bfs(mat);
        return cache;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    void bfs(int[][] mat) {
        boolean[][] vis = new boolean[m][n];
        Queue<P> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new P(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int step = 0;
        int size = q.size();
        while (!q.isEmpty()) {
            P p = q.poll();
            cache[p.x][p.y] = step;
            for (int k = 0; k < dir.length; k++) {
                int x1 = p.x + dir[k][0];
                int y1 = p.y + dir[k][1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !vis[x1][y1]) {
                    vis[x1][y1] = true;
                    q.offer(new P(x1, y1));
                }
            }
            size--;
            if (size == 0) {
                step++;
                size = q.size();
            }
        }
    }

    class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    void test() {
        int[][] mat = {
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }
}
