package AC2.A5;

import java.util.Scanner;

public class A291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row == 0 && col == 0) break;
            int max = getMax(row, col);
            System.out.println(max);
        }
    }

    static int getMax(int row, int col) {
        int[][] dp = new int[col + 1][1 << row];
        dp[0][0] = 1;
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < (1 << row); i++) {
                if (dp[j][i] != 0) {
                    fill(dp, i, 0, row, j, 0);
                }
            }
        }
        return dp[col][0];
    }

    static void fill(int[][] dp, int currCol, int nextCol, int row, int col, int idx) {
        if (idx == row) {
            dp[col + 1][nextCol] += dp[col][currCol];
            return;
        }
        if (((currCol >> idx) & 1) == 0) {
            fill(dp, currCol, nextCol | (1 << idx), row, col, idx + 1);
            if (idx < row - 1 && (currCol >> (idx + 1) & 1) == 0) {
                fill(dp, currCol, nextCol, row, col, idx + 2);
            }
        } else {
            fill(dp, currCol, nextCol, row, col, idx + 1);
        }
    }
}
