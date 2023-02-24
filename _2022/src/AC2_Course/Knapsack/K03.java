package AC2_Course.Knapsack;

import org.junit.jupiter.api.Test;

public class K03 {

    //2D
    public int maxValue2D(int[] v, int[] w, int[] s, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[0][V];
    }

    //1D
    public int maxValue1D(int[] v, int[] w, int[] s, int V) {
        int[] dp = new int[V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = dp.length - 1; j >= 0; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }

    @Test
    void test() {
        int[] v = {1, 2, 3, 4};
        int[] w = {2, 4, 4, 5};
        int[] s = {3, 1, 3, 2};
        int V = 5;

        System.out.println(maxValue2D(v, w, s, V));
        System.out.println(maxValue1D(v, w, s, V));
    }
}
