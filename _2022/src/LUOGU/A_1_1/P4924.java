package LUOGU.A_1_1;

import java.util.Scanner;

public class P4924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][m];
        int num = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = num++;
            }
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int r = sc.nextInt();
            int z = sc.nextInt();
            rotate(matrix, x, y, r, z);
        }
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix, int x, int y, int r, int z) {
        int x0 = x - r;
        int x1 = x + r;
        int y0 = y - r;
        int y1 = y + r;
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y0 + (y1 - y0) / 2; j++) {
                swap(matrix, i, j, i, y1 - (j - y0));
            }
        }
        if (z == 0) {
            for (int i = x0; i <= x1; i++) {
                for (int j = y0; j <= y1 - (i - x0); j++) {
                    swap(matrix, i, j, x1 - (j - y0), y1 - (i - x0));
                }
            }
        } else {
            for (int i = x0; i <= x1; i++) {
                for (int j = y1; j >= y0 + (i - x0); j--) {
                    swap(matrix, i, j, x1 - (y1 - j), y0 + (i - x0));
                }
            }
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int t = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = t;
    }
}
