package Leetcode.ACW_LeetCode;

public class LC79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bt(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }


    boolean bt(char[][] board, int x, int y, String word, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(idx)) return false;

        char c = board[x][y];
        board[x][y] = ' ';
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (bt(board, x1, y1, word, idx + 1)) {
                return true;
            }
        }
        board[x][y] = c;
        return false;
    }
}
