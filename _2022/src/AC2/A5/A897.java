package AC2.A5;

import java.util.Scanner;

public class A897 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();

        int max = maxLen(s1.toCharArray(), n, s2.toCharArray(), m);
        System.out.println(max);
    }

    static int maxLen(char[] c1, int n, char[] c2, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
