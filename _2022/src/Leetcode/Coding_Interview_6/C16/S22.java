package Leetcode.Coding_Interview_6.C16;

import java.util.List;

public class S22 {
    public List<String> printKMoves(int K) {
        int[][] b = new int[2 * K][2 * K];
        char[] dir = {'U', 'R', 'D', 'L'};
        dfs(b, K, K, 1, K);
        //todo
        return null;
    }

    void dfs(int[][] b, int x, int y, int direction, int k) {
        if (k == 0) {
            System.out.println(x + " : " + y + " : " + direction);
            return;
        }
        if (b[x][y] == 1) {
            int x1 = x;
            int y1 = y;
            if (direction == 0) {
                y1 -= 1;
            }
            if (direction == 1) {
                x1 -= 1;
            }
            if (direction == 2) {
                y1 += 1;
            }
            if (direction == 3) {
                x1 += 1;
            }
            direction = (direction - 1 + 4) % 4;
            b[x][y] = 0;
            dfs(b, x1, y1, direction, k - 1);
        } else {
            int x1 = x;
            int y1 = y;
            if (direction == 0) {
                y1 += 1;
            }
            if (direction == 1) {
                x1 += 1;
            }
            if (direction == 2) {
                y1 -= 1;
            }
            if (direction == 3) {
                x1 -= 1;
            }
            direction = (direction + 1) % 4;
            b[x][y] = 1;
            dfs(b, x1, y1, direction, k - 1);
        }
    }
}
