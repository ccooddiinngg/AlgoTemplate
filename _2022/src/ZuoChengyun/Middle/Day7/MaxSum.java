package ZuoChengyun.Middle.Day7;

import org.junit.jupiter.api.Test;

public class MaxSum {
    public static int find(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static int findInMatrix(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int[] flatten = flat(matrix, i, j);
                int found = find(flatten);
                max = Math.max(max, found);
            }
        }
        return max;
    }

    private static int[] flat(int[][] matrix, int i, int j) {
        int[] flatten = new int[matrix[0].length];
        for (int k = 0; k < matrix[0].length; k++) {
            for (int l = i; l < j; l++) {
                flatten[k] += matrix[l][k];
            }
        }
        return flatten;
    }

    @Test
    void test() {
        int[] arr = {1, 2, -1, -10, 11, 4, -6, 9, 20, -10, -2};
        System.out.println(find(arr));

        int[][] matrix = {{-5, 3, 6, 4}, {-7, 9, -5, 3}, {-10, 1, -200, 4}};
        System.out.println(findInMatrix(matrix));
    }
}
