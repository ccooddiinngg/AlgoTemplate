package AC3.A2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class A1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        P end = bfs(matrix, n, 0, 0, n - 1, n - 1);
        Stack<P> stack = new Stack<>();
        while (end != null) {
            stack.push(end);
            end = end.pre;
        }
        while (!stack.isEmpty()) {
            P p = stack.pop();
            System.out.println(p.x + " " + p.y);
        }
    }

    static P bfs(int[][] matrix, int n, int startX, int startY, int endX, int endY) {
        Queue<P> q = new LinkedList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];
        q.add(new P(startX, startY, null));
        while (!q.isEmpty()) {
            P curr = q.poll();
            if (curr.x == endX && curr.y == endY) {
                return curr;
            }
            for (int i = 0; i < dir.length; i++) {
                int x1 = curr.x + dir[i][0];
                int y1 = curr.y + dir[i][1];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && matrix[x1][y1] == 0 && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    q.add(new P(x1, y1, curr));
                }
            }
        }
        return null;
    }

    static class P {
        int x;
        int y;
        P pre;

        public P(int x, int y, P pre) {
            this.x = x;
            this.y = y;
            this.pre = pre;
        }
    }
}
