package Leetcode.Offer;

import java.util.LinkedList;
import java.util.Queue;

public class O13 {
    public int movingCount(int m, int n, int k) {
        return bfs(m, n, k);
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int bfs(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 0));
        visited[0][0] = true;
        int count = 1;
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int[] d : dir) {
                int x = p.x + d[0];
                int y = p.y + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && isValid(x, y, k)) {
                    visited[x][y] = true;
                    q.add(new P(x, y));
                    count++;
                }
            }
        }
        return count;
    }

    class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean isValid(int x, int y, int k) {
        int sum = getSumOfNum(x) + getSumOfNum(y);
        return sum <= k;
    }

    int getSumOfNum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
