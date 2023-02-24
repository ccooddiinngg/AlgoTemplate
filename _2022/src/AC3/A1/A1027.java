package AC3.A1;

import java.util.Scanner;

public class A1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n + 1][n + 1];
        while (true) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int v = sc.nextInt();
            if (row == 0 && col == 0 && v == 0) break;
            matrix[row][col] = v;
        }
        int max = getMax(matrix, n);
        System.out.println(max);
    }

    static int getMax(int[][] matrix, int n) {
//        [step][i1][i2]
        int[][][] dp = new int[2 * n + 1][n + 1][n + 1];
        for (int k = 2; k < 2 * n + 1; k++) {
            for (int i1 = 1; i1 < n + 1; i1++) {
                for (int i2 = 1; i2 < n + 1; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (j1 >= 1 && j1 < n + 1 && j2 >= 1 && j2 < n + 1) {
                        int t = matrix[i1][j1];
                        if (i1 != i2) {
                            t += matrix[i2][j2];
                        }
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                    }
                }
            }
        }

        return dp[2 * n][n][n];
    }
}
