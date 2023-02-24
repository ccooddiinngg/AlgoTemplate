package Leetcode.MostInterView;

import org.junit.jupiter.api.Test;

public class ValidSoduku {
    public boolean isValidSudoku(String[][] board) {
        int m = board.length;
        int[] map = new int[m];

        for (int i = 0; i < m; i++) {
            map = new int[m];
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ".") {
                    continue;
                }
                if (map[Integer.parseInt(String.valueOf(board[i][j])) - 1] != 0) {
                    return false;
                }
                map[Integer.parseInt(String.valueOf(board[i][j])) - 1]++;
            }
        }

        for (int j = 0; j < m; j++) {
            map = new int[m];
            for (int i = 0; i < m; i++) {
                if (board[i][j] == ".") {
                    continue;
                }
                if (map[Integer.parseInt(String.valueOf(board[i][j])) - 1] != 0) {
                    return false;
                }
                map[Integer.parseInt(String.valueOf(board[i][j])) - 1]++;
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                map = new int[m];
                for (int i = row * 3; i < row * 3 + 3; i++) {
                    for (int j = col * 3; j < col * 3 + 3; j++) {
                        if (board[i][j] == ".") {
                            continue;
                        }
                        if (map[Integer.parseInt(String.valueOf(board[i][j])) - 1] != 0) {
                            return false;
                        }
                        map[Integer.parseInt(String.valueOf(board[i][j])) - 1]++;
                    }
                }
            }

        }
        return true;
    }

    @Test
    void test() {
        String[][] board = {{".", ".", ".", ".", "5", ".", ".", "1", "."}, {".", "4", ".", "3", ".", ".", ".", ".", "."}, {".", ".", ".", ".", ".", "3", ".", ".", "1"}, {"8", ".", ".", ".", ".", ".", ".", "2", "."}, {".", ".", "2", ".", "7", ".", ".", ".", "."}, {".", "1", "5", ".", ".", ".", ".", ".", "."}, {".", ".", ".", ".", ".", "2", ".", ".", "."}, {".", "2", ".", "9", ".", ".", ".", ".", "."}, {".", ".", "4", ".", ".", ".", ".", ".", "."}};
        System.out.println(isValidSudoku(board));
    }

}
