package AC3.A1;

import java.util.Scanner;

public class A1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int min = find(v, V, n);
        System.out.println(min);
    }

    static int find(int[] v, int V, int n) {
        int[] dp = new int[V + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] += dp[j - v[i]];
            }
        }
//        System.out.println(Arrays.toString(dp));
        for (int j = V; j >= 0; j--) {
            if (dp[j] != 0) return V - j;
        }
        return 0;
    }
}
