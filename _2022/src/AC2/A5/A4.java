package AC2.A5;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int max = maxW(v, w, s, N, V);
        System.out.println(max);
    }

    static int maxW(int[] v, int[] w, int[] s, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = dp.length - 1; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= v[i] * k) {
                        dp[j] = Math.max(dp[j], dp[j - v[i] * k] + w[i] * k);
                    }
                }
            }
        }
        return dp[V];
    }
}
