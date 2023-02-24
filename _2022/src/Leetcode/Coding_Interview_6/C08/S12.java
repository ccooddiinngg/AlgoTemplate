package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.List;

public class S12 {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] v = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        int[] board = new int[n];
        dfs(n, 0, board, v, d1, d2);
        return list;
    }

    void dfs(int n, int row, int[] board, boolean[] v, boolean[] d1, boolean[] d2) {
        if (row == n) {
            // System.out.println(Arrays.toString(board));
            addBoard(board);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!v[j] && !d1[row + j] && !d2[row - j + n]) {
                board[row] = j;
                v[j] = true;
                d1[row + j] = true;
                d2[row - j + n] = true;
                dfs(n, row + 1, board, v, d1, d2);
                v[j] = false;
                d1[row + j] = false;
                d2[row - j + n] = false;
            }
        }
    }

    void addBoard(int[] board) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            b.add(sb.toString());
        }
        list.add(b);
    }
}
