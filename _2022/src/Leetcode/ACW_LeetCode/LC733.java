package Leetcode.ACW_LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        Queue<P> q = new LinkedList<>();
        q.add(new P(sr, sc));
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            P p = q.poll();
            image[p.x][p.y] = newColor;
            for (int[] d : dir) {
                int x1 = p.x + d[0];
                int y1 = p.y + d[1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && image[x1][y1] == oldColor) {
                    q.add(new P(x1, y1));
                }
            }
        }
        return image;
    }

    class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
