package AC3.A1;

import java.util.Scanner;

public class A1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        for (int k = 0; k < g; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int max = getMax(matrix, n, m);
            System.out.println(max);
        }
    }

    static int getMax(int[][] matrix, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i - 1][j - 1];
            }
        }

        return dp[n][m];
    }
}
