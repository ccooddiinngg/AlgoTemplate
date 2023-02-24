package AC2_Course.Graph;

import java.util.ArrayList;
import java.util.List;

public class A843 {
    public static void main(String[] args) {

        int N = 4;
        int[] board = new int[N];
        boolean[] v = new boolean[N];
        boolean[] d1 = new boolean[N * 2];
        boolean[] d2 = new boolean[N * 2];

        List<int[]> list = new ArrayList<>();
        dfs(board, 0, list, v, d1, d2, N);
        for (int[] b : list) {
            printBoard(b);
            System.out.println();
        }
    }

    public static void dfs(int[] board, int row, List<int[]> list, boolean[] v, boolean[] d1, boolean[] d2, int N) {
        if (row == board.length) {
            int[] t = new int[board.length];
            System.arraycopy(board, 0, t, 0, t.length);
            list.add(t);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isValid(row, j, v, d1, d2, N)) {
                board[row] = j;
                v[j] = true;
                d1[row + j] = true;
                d2[j - row + N - 1] = true;
                dfs(board, row + 1, list, v, d1, d2, N);
                board[row] = 0;
                v[j] = false;
                d1[row + j] = false;
                d2[j - row + N - 1] = false;
            }
        }
    }

    public static void printBoard(int[] board) {
        int m = board.length;
        for (int k : board) {
            for (int j = 0; j < m; j++) {
                if (k == j) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static boolean isValid(int i, int j, boolean[] v, boolean[] d1, boolean[] d2, int N) {
        return !v[j] && !d1[i + j] && !d2[j - i + N - 1];
    }
}
