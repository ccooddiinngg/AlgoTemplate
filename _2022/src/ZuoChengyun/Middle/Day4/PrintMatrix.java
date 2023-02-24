package ZuoChengyun.Middle.Day4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    public static void printMatrix(int[][] matrix, List<Integer> list) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i1 = 0, j1 = 0, i2 = m - 1, j2 = n - 1; i1 <= i2 && j1 <= j2; i1++, j1++, i2--, j2--) {
            if (i1 == i2) {
                for (int j = j1; j <= j2; j++) {
                    list.add(matrix[i1][j]);
                }
                break;
            }
            if (j1 == j2) {
                for (int i = i1; i <= i2; i++) {
                    list.add(matrix[i][j2]);
                }
                break;
            }
            for (int j = j1; j <= j2; j++) {
                list.add(matrix[i1][j]);
            }
            for (int i = i1 + 1; i <= i2; i++) {
                list.add(matrix[i][j2]);
            }

            for (int j = j2 - 1; j >= j1; j--) {
                list.add(matrix[i2][j]);
            }
            for (int i = i2 - 1; i > i1; i--) {
                list.add(matrix[i][j1]);
            }
        }
    }

    @Test
    void test() {
        int[][] matrix = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {9, 10, 11}};
        List<Integer> list = new ArrayList<>();
        printMatrix(matrix, list);
        System.out.println(list);
    }
}
