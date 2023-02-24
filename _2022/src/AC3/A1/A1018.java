package AC3.A1;

import java.util.Scanner;

public class A1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int min = getMin(matrix, n);
        System.out.println(min);
    }

    //2n-1 steps mean can only go right or down
    static int getMin(int[][] matrix, int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }

    //can pass
    static int getMin1(int[][] matrix, int n) {
        int[][][] dp = new int[2 * n][n][n];
        for (int k = 0; k < 2 * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        dp[0][0][0] = matrix[0][0];
        for (int k = 1; k < 2 * n; k++) {
            for (int i = 0; i < n; i++) {
                int j = k - i;
                if (j >= 0 && j < n) {
                    for (int d = 0; d < 4; d++) {
                        int i1 = i + dx[d];
                        int j1 = j + dy[d];
                        if (i1 < n && i1 >= 0 && j1 < n && j1 >= 0 && dp[k - 1][i1][j1] < Integer.MAX_VALUE) {
                            dp[k][i][j] = Math.min(dp[k][i][j], dp[k - 1][i1][j1] + matrix[i][j]);
                        }
                    }
                }
            }
        }
//        for (int[][] xy : dp) {
//            for (int[] x : xy) {
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println(" ---  ");
//        }
        return dp[2 * n - 2][n - 1][n - 1];
    }
}
