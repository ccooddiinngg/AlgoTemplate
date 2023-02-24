package Leetcode.NeetCode;


//@@ cache
public class N329 {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j, cache));
            }
        }

        return max + 1;
    }

    public int helper(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int num = matrix[i][j];
        int[] dir = new int[4];
        if (i - 1 >= 0 && matrix[i - 1][j] > num) {
            dir[0] = helper(matrix, i - 1, j, cache);
            cache[i - 1][j] = dir[0];
            dir[0] += 1;
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > num) {
            dir[1] = helper(matrix, i + 1, j, cache);
            cache[i + 1][j] = dir[1];
            dir[1] += 1;
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > num) {
            dir[2] = helper(matrix, i, j + 1, cache);
            cache[i][j + 1] = dir[2];
            dir[2] += 1;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > num) {
            dir[3] = helper(matrix, i, j - 1, cache);
            cache[i][j - 1] = dir[3];
            dir[3] += 1;
        }

        int max = 0;
        for (int len : dir) {
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}
