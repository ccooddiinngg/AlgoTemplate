package AC2.A3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int min = bfs(board, new P(0, 0));
        System.out.println(min);
    }

    private static int bfs(int[][] board, P p) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        Queue<P> q = new LinkedList<>();
        q.add(p);
        int size = q.size();
        while (size > 0) {
            P curr = q.poll();
            if (curr.x == board.length - 1 && curr.y == board[0].length - 1) {
                return step;
            }
            for (int i = 0; i < 4; i++) {
                int x = curr.x + dir[i][0];
                int y = curr.y + dir[i][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 0) {
                    board[x][y] = 1;
                    q.add(new P(x, y));
                }
            }
            size--;
            if (size == 0) {
                step++;
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
