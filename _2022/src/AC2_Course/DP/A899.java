package AC2_Course.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
3 2
abc
acd
bcd
ab 1
acbd 2
*/
public class A899 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            String s1 = sc.next();
            int max = Integer.parseInt(sc.next());
            int count = 0;
            for (String s2 : list) {
                if (trans(s1, s2, 1, 1, 1) <= max) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // l2 -> l1
    public static int trans(String s1, String s2, int add, int del, int rep) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + add;
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] + del;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int a = dp[i - 1][j] + add;
                int d = dp[i][j - 1] + del;
                int r = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + rep;
                dp[i][j] = Math.min(a, Math.min(d, r));
            }
        }

        return dp[l1][l2];
    }

}
