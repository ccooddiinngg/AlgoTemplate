package tag.DynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        int insert = 1;
        int delete = 1;
        int replace = 1;
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = dp[0][j - 1] + insert;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i - 1][0] + delete;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + replace;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + delete);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + insert);
            }
        }
        return dp[m][n];
    }
}
