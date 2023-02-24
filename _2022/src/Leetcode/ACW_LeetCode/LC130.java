package Leetcode.ACW_LeetCode;

public class LC130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') bt(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    void bt(char[][] b, int x, int y) {
        if (x < 0 || x == b.length || y < 0 || y == b[0].length || b[x][y] == 'X' || b[x][y] == '.') return;
        b[x][y] = '.';
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            bt(b, x1, y1);
        }
    }
}
