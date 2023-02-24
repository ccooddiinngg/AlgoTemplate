package AC2.A5;

import java.util.Scanner;

public class A900 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
    }

    static int find(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }
        }
        return dp[n];
    }
}
