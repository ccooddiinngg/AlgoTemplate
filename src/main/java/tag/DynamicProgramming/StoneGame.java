package tag.DynamicProgramming;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int m = piles.length;
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    dp[i][j] = piles[i];
                } else {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][m - 1] >= 0;
    }
}
