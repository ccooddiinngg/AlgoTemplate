package AC2_Course.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class K04a {
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
        int max = getMax(v, w, s, N, V);
        System.out.println(max);
    }

    static int getMax(int[] v, int[] w, int[] s, int n, int V) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            Integer[] q = getQty(s[i]);
            for (int k = 0; k < q.length; k++) {
                for (int j = V; j >= q[k] * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - q[k] * v[i]] + q[k] * w[i]);
                }
            }
        }
        return dp[V];
    }

    static Integer[] getQty(int s) {
        List<Integer> list = new ArrayList<>();
        int pow = 1;
        while (s >= pow) {
            list.add(pow);
            s -= pow;
            pow *= 2;
        }
        if (s > 0) {
            list.add(s);
        }
        return list.toArray(new Integer[0]);
    }
}
