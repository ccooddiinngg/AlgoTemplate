package AC2_Course.Knapsack;

import java.util.Arrays;

public class K10 {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4};
        int[] w = {2, 4, 4, 6};
        int V = 5;

        System.out.println(maxValueWays(v, w, V));
    }

    public static int maxValueWays(int[] v, int[] w, int V) {
        int mod = (int) (1e9 + 7);
        int[] dp = new int[V + 1];
        int[] ways = new int[V + 1];
        Arrays.fill(ways, 1);
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = V; j >= v[i]; j--) {
                int t = Math.max(dp[j], dp[j - v[i]] + w[i]);
                int s = 0;
                if (dp[j] == t) {
                    s += ways[j];
                }
                if (dp[j - v[i]] + w[i] == t) {
                    s += ways[j - v[i]];
                }
                dp[j] = t;
                ways[j] = s % mod;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(ways));
        return ways[V];
    }
}
