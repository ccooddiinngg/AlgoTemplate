package AC3.A1;

import java.util.Scanner;

public class A1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        long res = find(v, n, V);
        System.out.println(res);
    }

    static long find(int[] v, int n, int V) {
        long[] dp = new long[V + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = v[i]; j < V + 1; j++) {
                dp[j] += dp[j - v[i]];
            }
        }
        return dp[V];
    }
}
