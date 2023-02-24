package AC2_Course.DP;

import java.util.Arrays;
import java.util.Scanner;

public class A901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] cache = new int[n][m];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                len = Math.max(len, dfs(i, j, matrix, cache));
            }
        }

        System.out.println(len);
    }

    public static int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int next = 1;
        if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
            next = Math.max(next, dfs(i - 1, j, matrix, cache) + 1);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
            next = Math.max(next, dfs(i + 1, j, matrix, cache) + 1);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
            next = Math.max(next, dfs(i, j - 1, matrix, cache) + 1);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
            next = Math.max(next, dfs(i, j + 1, matrix, cache) + 1);
        }
        cache[i][j] = next;
        return next;
    }

}
