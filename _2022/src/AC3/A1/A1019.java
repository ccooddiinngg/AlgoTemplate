package AC3.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int max = getMax(v, w, s, n, V);
        System.out.println(max);
    }

    static int getMax(int[] v, int[] w, int[] s, int n, int V) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            List<Integer> q = getQty(s[i]);
            for (int qty : q) {
                for (int j = V; j >= qty * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - qty * v[i]] + qty * w[i]);
                }
            }
        }
        return dp[V];
    }

    private static List<Integer> getQty(int s) {
        List<Integer> q = new ArrayList<>();
        int pow = 1;
        while (s >= pow) {
            q.add(pow);
            s -= pow;
            pow *= 2;
        }
        if (s > 0) {
            q.add(s);
        }
        return q;
    }
}
