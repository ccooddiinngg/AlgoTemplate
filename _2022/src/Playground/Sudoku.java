package Playground;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    public int[][] board;

    public Sudoku() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Playground/SudokuData.txt"));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("===========================");
    }

    public boolean dfs(int i, int j) {
        if (i == 8 && j == 9) {
            return true;
        }
        if (j == 9) {
            i++;
            j = 0;
        }
        if (board[i][j] != 0) {
            return dfs(i, j + 1);
        } else {
            for (int v = 1; v <= 9; v++) {
                if (isValid(i, j, v)) {
                    board[i][j] = v;
                    if (dfs(i, j + 1)) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
            return false;
        }

    }

    boolean isValid(int i, int j, int v) {
        for (int r = 0; r < 9; r++) {
            if (board[r][j] == v) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (board[i][c] == v) {
                return false;
            }
        }
        int row = i / 3 * 3;
        int col = j / 3 * 3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (board[row + m][col + n] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var sudoku = new Sudoku();
        if (sudoku.dfs(0, 0)) {
            for (int[] row : sudoku.board) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("===========================");

        }

    }
}
