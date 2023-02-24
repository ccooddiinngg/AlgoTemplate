package Leetcode.Coding_Interview_6.C16;

public class S04 {
    boolean finish = false;

    public String tictactoe(String[] board) {
        int n = board.length;
        if (check(board, 'X', n)) {
            return "X";
        }
        if (check(board, 'O', n)) {
            return "O";
        }
        if (finish) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    boolean check(String[] board, char c, int n) {
        int[] countD1 = new int[2 * n];
        int[] countD2 = new int[2 * n];
        int[] countRow = new int[n];
        int[] countCol = new int[n];
        finish = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == c) {
                    countRow[i]++;
                    if (countRow[i] == n) return true;
                    countCol[j]++;
                    if (countCol[j] == n) return true;
                    countD1[i + j]++;
                    if (countD1[i + j] == n) return true;
                    countD2[i - j + n]++;
                    if (countD2[i - j + n] == n) return true;
                }
                if (board[i].charAt(j) == ' ') finish = false;
            }
        }
        return false;
    }
}
