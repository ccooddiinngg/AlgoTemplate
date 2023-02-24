package AC2_Course.DP;

import java.util.Scanner;

public class A900 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n + 2][n + 1];
        for (int i = 1; i <= n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= i) {
                    dp[i][j] += dp[i][j - i];
                    dp[i][j] %= 1e9 + 7;
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}

