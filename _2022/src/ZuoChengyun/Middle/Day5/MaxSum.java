package ZuoChengyun.Middle.Day5;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class MaxSum {
    public static int findMax(int[][] matrix, int x, int y, int m, int n) {
        if (x == m || y == n) {
            return Integer.MAX_VALUE;
        }
        if (x == m - 1 && y == n - 1) {
            return matrix[x][y];
        }
        int oRight = findMax(matrix, x, y + 1, m, n);
        int oDown = findMax(matrix, x + 1, y, m, n);

        return Math.min(oRight, oDown) + matrix[x][y];
    }

    public static int findMaxDP(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            dp[m][j] = Integer.MAX_VALUE;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + matrix[i][j];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[0][0];
    }

    @Test
    void test() {
        int[][] matrix = {{1, 3, 2}, {6, 5, 7}, {8, 4, 9}};
        System.out.println(findMax(matrix, 0, 0, matrix.length, matrix[0].length));
        System.out.println(findMaxDP(matrix));
    }
}
