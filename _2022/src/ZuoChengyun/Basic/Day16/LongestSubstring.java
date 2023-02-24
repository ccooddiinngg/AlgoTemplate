package ZuoChengyun.Basic.Day16;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class LongestSubstring {

    public static int find(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int[][] dp = new int[a.length()][b.length()];

        for (int i = 0; i < charA.length; i++) {
            dp[i][0] = (charA[i] == charB[0] || (i >= 1 && dp[i - 1][0] == 1)) ? 1 : 0;
        }
        for (int j = 0; j < charB.length; j++) {
            dp[0][j] = (charB[j] == charA[0] || (j >= 1 && dp[0][j - 1] == 1)) ? 1 : 0;
        }

        for (int i = 1; i < charA.length; i++) {
            for (int j = 1; j < charB.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (charA[i] == charB[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[charA.length - 1][charB.length - 1];
    }

    @Test
    void findTest() {
        String a = "a12b34c56d";
        String b = "dabcdad";

        int max = find(a, b);
        System.out.println(max);
    }
}
