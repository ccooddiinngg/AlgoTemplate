package AC2.A3;

import java.util.Scanner;

public class A843 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n, 0, new int[n][n], new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private static void dfs(int n, int row, int[][] board, boolean[] v, boolean[] d1, boolean[] d2) {
        if (row == n) {
            print(board);
        }
        for (int j = 0; j < n; j++) {
//            if (valid(board, row, j)) {
//                board[row][j] = 1;
//                dfs(n, row + 1, board);
//                board[row][j] = 0;
//            }
            if (isValid(n, row, j, v, d1, d2)) {
                board[row][j] = 1;
                v[j] = true;
                d1[row + j] = true;
                d2[row - j + n - 1] = true;
                dfs(n, row + 1, board, v, d1, d2);
                board[row][j] = 0;
                v[j] = false;
                d1[row + j] = false;
                d2[row - j + n - 1] = false;
            }
        }
    }

//    private static boolean valid(int[][] board, int row, int j) {
//        if (row == 0) {
//            return true;
//        }
//        int n = board[0].length;
//        for (int i = 0; i < row; i++) {
//            if (board[i][j] == 1) {
//                return false;
//            }
//        }
//        for (int i = row - 1; i >= Math.max(0, (row + j) - n + 1); i--) {
//            if (board[i][row + j - i] == 1) {
//                return false;
//            }
//        }
//        for (int i = row - 1; i >= Math.max(0, row - j); i--) {
//            if (board[i][i - (row - j)] == 1) {
//                return false;
//            }
//        }
//        return true;
//    }

    static boolean isValid(int n, int row, int j, boolean[] v, boolean[] d1, boolean[] d2) {
        return !v[j] && !d1[row + j] && !d2[row - j + n - 1];
    }

    private static void print(int[][] board) {
        for (int[] row : board) {
            for (int j : row) {
                if (j == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("Q");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
