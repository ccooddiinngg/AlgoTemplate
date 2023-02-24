package AC2.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A899 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            String s2 = sc.next();
            int max = Integer.parseInt(sc.next());
            int count = 0;
            for (String s1 : list) {
                if (minDis(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length(), 1, 1, 1) <= max) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static int minDis(char[] c1, int n, char[] c2, int m, int add, int replace, int del) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + replace;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + del);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + add);
            }
        }
        return dp[n][m];
    }
}
