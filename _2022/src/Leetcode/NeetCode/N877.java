package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

//@@ from bottom to up , from left to right
public class N877 {
    public boolean stoneGame(int[] piles) {
        int m = piles.length;
        int[][] offensive = new int[m][m];
        int[][] defensive = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    offensive[i][j] = piles[i];
                }
            }
        }

        //@@
        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                offensive[i][j] = Math.max(piles[i] + defensive[i + 1][j], piles[j] + defensive[i][j - 1]);
                defensive[i][j] = Math.min(offensive[i + 1][j], offensive[i][j - 1]);
            }
        }
//        Utils.print2DArray(offensive);
//        Utils.print2DArray(defensive);

        return offensive[0][m - 1] > defensive[0][m - 1];
    }

    @Test
    void test() {
        int[] piles = {7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24};
//        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }
}
