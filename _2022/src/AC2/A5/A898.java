package AC2.A5;

import java.util.Scanner;

public class A898 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int max = maxPath(matrix, n);
        System.out.println(max);
    }

    static int maxPath(int[][] matrix, int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + matrix[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp[n - 1]) {
            max = Math.max(max, num);
        }
        return max;
    }
}
