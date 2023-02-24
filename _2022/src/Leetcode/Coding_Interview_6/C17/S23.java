package Leetcode.Coding_Interview_6.C17;

public class S23 {
    public int[] findSquare(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[3];

        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            right[i][n - 1] = matrix[i][n - 1] == 0 ? 1 : 0;
            for (int j = n - 2; j >= 0; j--) {
                right[i][j] = matrix[i][j] == 0 ? matrix[i][j + 1] == 0 ? right[i][j + 1] + 1 : 1 : 0;
            }
        }

        int[][] down = new int[m][n];
        for (int j = 0; j < n; j++) {
            down[m - 1][j] = matrix[m - 1][j] == 0 ? 1 : 0;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = matrix[i][j] == 0 ? matrix[i + 1][j] == 0 ? down[i + 1][j] + 1 : 1 : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int len = extend(matrix, m, n, i, j, right, down);
                    if (len > res[2]) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = len;
                    }
                }
            }
        }
        if (res[2] > 0) {
            return res;
        } else {
            return new int[0];
        }
    }

    int extend(int[][] matrix, int m, int n, int x, int y, int[][] right, int[][] down) {
        int len = m - 1 - x;
        while (len > 0) {
            if (right[x][y] >= len + 1 && right[x + len][y] >= len + 1 && down[x][y] >= len + 1 && down[x][y + len] >= len + 1) {
                break;
            } else {
                len--;
            }
        }
        return len + 1;
    }
}
