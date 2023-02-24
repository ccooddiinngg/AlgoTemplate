package ZuoChengyun.Middle.Day3;

import org.junit.jupiter.api.Test;

public class FindNum {

    //starts from right-top
    public static boolean find2(int[][] matrix, int tar) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == tar) return true;
            if (matrix[i][j] < tar) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    @Test
    void test() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {10, 20, 30, 40},
                {15, 25, 35, 45}};
        int target = 25;
        System.out.println(find2(matrix, target));
    }
}
