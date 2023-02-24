package ZuoChengyun.Middle.Day4;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ZigzagPrint {
    public static void print(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean b = true;
        for (int i = 0; i < m; i++) {
            printLine(i, 0, b, matrix, m, n);
            b = !b;
        }
        for (int j = 1; j < n; j++) {
            printLine(m - 1, j, b, matrix, m, n);
            b = !b;
        }

    }

    private static void printLine(int x, int y, boolean b, int[][] matrix, int m, int n) {
        if (b) {
            while (x >= 0 && y < n) {
                System.out.println(matrix[x][y]);
                x--;
                y++;
            }
        } else {
            Stack<Integer> stack = new Stack<>();
            while (x >= 0 && y < n) {
                stack.add(matrix[x][y]);
                x--;
                y++;
            }
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

    }

    @Test
    void test() {
        int[][] matrix = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        print(matrix);
    }

}
