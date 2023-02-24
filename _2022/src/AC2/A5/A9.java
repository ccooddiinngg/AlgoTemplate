package AC2.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        List<List<P>> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            group.add(new ArrayList<>());
        }
        for (List<P> sub : group) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                sub.add(new P(sc.nextInt(), sc.nextInt()));
            }
        }
        int max = maxW(group, n, V);
        System.out.println(max);
    }

    static int maxW(List<List<P>> group, int n, int V) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= 0; j--) {
                for (P p : group.get(i)) {
                    if (j >= p.v) {
                        dp[j] = Math.max(dp[j], dp[j - p.v] + p.w);
                    }
                }
            }
        }
        return dp[V];
    }

    static class P {
        int v;
        int w;

        public P(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
