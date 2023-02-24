package ZuoChengyun.Middle.Day1;

import org.junit.jupiter.api.Test;

public class BiggestSquare {
    public static int find(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    right[i][j] = 0;
                } else {
                    right[i][j] = j == n - 1 ? 1 : 1 + right[i][j + 1];
                }
            }
        }
        int[][] down = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = i == m - 1 ? 1 : 1 + down[i + 1][j];
                }
            }
        }
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = 1; s <= Math.min(m - i, n - j); s++) {
                    if (down[i][j] >= s && down[i][j + s - 1] >= s && right[i][j] >= s && right[i + s - 1][j] >= s) {
                        max = Math.max(max, s * s);
                    }
                }
            }
        }
        return max;
    }

    @Test
    void test() {
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(find(matrix));
    }
}
