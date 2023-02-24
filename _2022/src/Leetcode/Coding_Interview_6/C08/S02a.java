package Leetcode.Coding_Interview_6.C08;

import java.util.*;

public class S02a {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        List<List<Integer>> path = new ArrayList<>();

        if (obstacleGrid[0][0] == 1) return path;
        P end = bfs(obstacleGrid, m, n);
        while (end != null) {
            path.add(0, Arrays.asList(end.x, end.y));
            end = end.pre;
        }
        return path;
    }

    private P bfs(int[][] obstacleGrid, int m, int n) {
        Queue<P> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        q.add(new P(0, 0, null));
        P end = null;
        while (!q.isEmpty()) {
            P curr = q.poll();
            if (curr.x == m - 1 && curr.y == n - 1) {
                end = curr;
                break;
            }
            for (int d = 0; d < 2; d++) {
                int x1 = curr.x + dx[d];
                int y1 = curr.y + dy[d];
                if (x1 < m && y1 < n && obstacleGrid[x1][y1] == 0 && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    q.add(new P(x1, y1, curr));
                }
            }
        }
        return end;
    }

    class P {
        P pre;
        int x;
        int y;

        public P(int x, int y, P pre) {
            this.x = x;
            this.y = y;
            this.pre = pre;
        }
    }
}
