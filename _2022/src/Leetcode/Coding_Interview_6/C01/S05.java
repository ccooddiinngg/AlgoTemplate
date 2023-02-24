package Leetcode.Coding_Interview_6.C01;

public class S05 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (m == 0 && n == 0) return true;
        if (Math.abs(m - n) > 1) return false;

        if (m < n) {
            return oneEditAway(second, first);
        }

        if (m == n) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    count++;
                }
            }
            return count <= 1;
        } else {
            int i = 0;
            int j = 0;
            int count = 0;
            while (i < m && j < n) {
                if (first.charAt(i) != second.charAt(j)) {
                    count++;
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            return count <= 1;
        }
    }

    /*public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (m == 0 && n == 0) return true;
        if (Math.abs(m - n) > 1) return false;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[m][n] <= 1;
    }*/

}
