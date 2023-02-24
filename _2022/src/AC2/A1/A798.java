package AC2.A1;

import java.util.Scanner;

public class A798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] factor = preFactor(matrix, n, m);
        // for (int[] row : factor) {
        //     System.out.println(Arrays.toString(row));
        // }
        for (int i = 0; i < q; i++) {
            int i1 = sc.nextInt();
            int j1 = sc.nextInt();
            int i2 = sc.nextInt();
            int j2 = sc.nextInt();
            int v = sc.nextInt();
            change(factor, n, m, i1 - 1, j1 - 1, i2 - 1, j2 - 1, v);
        }
        int[][] sum = preSum(factor, n, m);
        for (int[] row : sum) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static int[][] preFactor(int[][] matrix, int n, int m) {
        int[][] factor = new int[n][m];
        for (int i = 0; i < n; i++) {
            factor[i][0] = matrix[i][0];
            for (int j = 1; j < m; j++) {
                factor[i][j] = matrix[i][j] - matrix[i][j - 1];
            }
        }
        //差分要从下往上计算，如果从上往下，上一行已经变化
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                factor[i][j] -= factor[i - 1][j];
            }
        }
        return factor;
    }

    static int[][] preSum(int[][] matrix, int n, int m) {
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            sum[i][0] = matrix[i][0];
            for (int j = 1; j < m; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
            if (i == 0) continue;
            for (int j = 0; j < m; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }
        return sum;
    }

    static void change(int[][] matrix, int n, int m, int i1, int j1, int i2, int j2, int v) {
        matrix[i1][j1] += v;
        if (i2 + 1 < n) {
            matrix[i2 + 1][j1] -= v;
        }
        if (j2 + 1 < m) {
            matrix[i1][j2 + 1] -= v;
        }
        if (i2 + 1 < n && j2 + 1 < m) {
            matrix[i2 + 1][j2 + 1] += v;
        }
    }

}
