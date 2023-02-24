package AC3.A1;

import java.util.Scanner;

public class A275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int max = getMax(matrix, m, n);
        System.out.println(max);

    }

    /*
     * 状态为第一个点的坐标p1和第二个点的坐标p2， 两个点同时移动到终点，k为步数, (j1=k-i1, j2=k-i2)
     * 转移方程为: f[k][i1][i2] = max(f[k-1][i1-1][i2], f[k-1][i1][i2-1], f[k-1][i1-1][i2-1],f[k-1][i1][i2])
     * p1: top -> down, left -> right
     * p2: top -> down, left -> right
     * */
    static int getMax(int[][] matrix, int m, int n) {
        int[][][] dp = new int[(m + n) - 1][m][m];
        for (int k = 1; k < (m + n) - 1; k++) {
            for (int i1 = 0; i1 < m; i1++) {
                for (int i2 = 0; i2 < m; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;

                    if (j1 >= 0 && j2 >= 0 && j1 < n && j2 < n) {
                        int t = matrix[i1][j1];
                        if (i1 != i2) {
                            t += matrix[i2][j2];
                        }
                        if (i1 - 1 >= 0 && i2 - 1 >= 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                        }
                        if (i2 - 1 >= 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                        }
                        if (i1 - 1 >= 0) {
                            dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                        }
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                    }
                }
            }
        }
        return dp[(m + n) - 2][m - 1][m - 1];
    }
}
