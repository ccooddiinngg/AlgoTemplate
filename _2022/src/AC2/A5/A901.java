package AC2.A5;

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
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, getMax(matrix, n, m, i, j, cache));
            }
        }
        System.out.println(max);
    }

    static int getMax(int[][] matrix, int n, int m, int x, int y, int[][] cache) {
        if (cache[x][y] != -1) {
            return cache[x][y];
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int next = 0;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < m && matrix[x1][y1] < matrix[x][y]) {
                next = Math.max(next, getMax(matrix, n, m, x1, y1, cache));
            }
        }
        cache[x][y] = next + 1;
        return next + 1;
    }


}
