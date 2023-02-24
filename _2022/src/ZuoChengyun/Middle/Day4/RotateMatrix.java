package ZuoChengyun.Middle.Day4;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class RotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1 - i; j >= 0; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
    }

    @Test
    void test() {
        int[][] matrix = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        rotateMatrix(matrix);
        rotateMatrix(matrix);
        rotateMatrix(matrix);
        rotateMatrix(matrix);
        Utils.print2DArray(matrix);
    }
}
