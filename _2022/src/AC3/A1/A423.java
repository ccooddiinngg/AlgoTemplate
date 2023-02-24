package AC3.A1;

import java.util.Scanner;

public class A423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int max = getMax(v, w, V, n);
        System.out.println(max);
    }

    static int getMax(int[] v, int[] w, int V, int n) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
