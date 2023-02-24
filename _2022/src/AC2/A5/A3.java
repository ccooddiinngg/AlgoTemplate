package AC2.A5;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int max = maxW(v, w, N, V);
        System.out.println(max);
    }

    static int maxW(int[] v, int[] w, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = v[i]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
