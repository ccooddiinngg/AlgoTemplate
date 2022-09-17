package tag.BackTracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bt(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    boolean bt(char[][] board, int x, int y, String word, int idx) {
        if (board[x][y] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        char t = board[x][y];
        board[x][y] = '*';
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length) {
                if (bt(board, x1, y1, word, idx + 1)) {
                    return true;
                }
            }
        }
        board[x][y] = t;
        return false;
    }
}
