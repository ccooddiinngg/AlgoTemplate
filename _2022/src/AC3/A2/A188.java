package AC3.A2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A188 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] matrix = new String[m][n];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < m; i++) {
            String[] s = sc.next().split("");
            for (int j = 0; j < n; j++) {
                if (s[j].equals("K")) {
                    startX = i;
                    startY = j;
                }
                if (s[j].equals("H")) {
                    endX = i;
                    endY = j;
                }
                matrix[i][j] = s[j];
            }
        }
        int count = bfs(matrix, m, n, startX, startY, endX, endY);
        System.out.println(count);
    }

    static int bfs(String[][] matrix, int m, int n, int startX, int startY, int endX, int endY) {
        int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<P> q = new LinkedList<>();
        q.add(new P(startX, startY));
        int count = 0;
        int size = q.size();
        while (!q.isEmpty()) {
            P curr = q.poll();
            size--;
            if (curr.x == endX && curr.y == endY) {
                return count;
            }
            for (int i = 0; i < dir.length; i++) {
                int x1 = curr.x + dir[i][0];
                int y1 = curr.y + dir[i][1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !matrix[x1][y1].equals("*") && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    q.add(new P(x1, y1));
                }
            }
            if (size == 0) {
                count++;
                size = q.size();
            }
        }
        return -1;
    }

    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
