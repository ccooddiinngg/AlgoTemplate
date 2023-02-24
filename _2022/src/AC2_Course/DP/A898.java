package AC2_Course.DP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A898 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/DP/A898Data.txt"));
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = sc.nextInt();
                matrix[i][j] = num;
            }
        }

        int[][] dp = new int[n][n];
        for (int j = 0; j <= n - 1; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + matrix[i][j];
            }
        }

        System.out.println(dp[0][0]);
    }
}
