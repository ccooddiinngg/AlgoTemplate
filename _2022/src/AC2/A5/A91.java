package AC2.A5;

import java.util.Arrays;
import java.util.Scanner;

public class A91 {
    private static int INF = 0x3f3f3f3f;

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

    static int getMin(int[][] matrix, int n) {
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][1] = 0;
        //先循环j， 表示从经过少的点(0001)到经过多的点(1111)
        for (int j = 0; j < (1 << n); j++) {
            //不考虑不经过0的点
            if ((j & 1) == 0) continue;
            for (int i = 1; i < n; i++) {
                //经过i的点
                if (((j >> i) & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        //经过k的点
                        if (((j >> k) & 1) == 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[k][j ^ (1 << i)] + matrix[i][k]);
                        }
                    }
                }
            }
        }

        return dp[n - 1][(1 << n) - 1];
    }
}
