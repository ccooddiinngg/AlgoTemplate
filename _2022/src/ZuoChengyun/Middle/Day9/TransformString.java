package ZuoChengyun.Middle.Day9;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class TransformString {
    public static int find(String s1, String s2, int insert, int delete, int replace) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + delete;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + insert;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int v0 = dp[i - 1][j - 1] + replace;
                int v1 = dp[i - 1][j] + delete;
                int v2 = dp[i][j - 1] + insert;
                int v3 = Integer.MAX_VALUE;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    v3 = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.min(Math.min(v0, v1), Math.min(v2, v3));

            }
        }
        Utils.print2DArray(dp);
        return dp[m][n];
    }

    @Test
    void test() {
        String s1 = "abc";
        String s2 = "adc";
        System.out.println(find(s1, s2, 5, 3, 2));
    }
}
