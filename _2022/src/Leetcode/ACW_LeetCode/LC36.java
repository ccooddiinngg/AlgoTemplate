package Leetcode.ACW_LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (char c: board[i]) {
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }

        for (int j = 0; j < 9; j++) {
            set.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int i1 = i * 3; i1 < i * 3 + 3; i1++) {
                    for (int j1 = j * 3; j1 < j * 3 + 3; j1++) {
                        if (board[i1][j1] == '.') continue;
                        if (set.contains(board[i1][j1])) return false;
                        set.add(board[i1][j1]);
                    }
                }
            }
        }

        return true;
    }
}
