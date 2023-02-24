package AC2_Course.DP;

public class Knapsack {
    public static void main(String[] args) {
        int[] w = {2, 4, 4, 5};
        int[] v = {1, 2, 3, 4};
        int V = 5;
        System.out.println("#### 01 ####");
        System.out.println(knapsack01(v, w, V, 0));
        System.out.println(knapsack01DP_v1(v, w, V));
        System.out.println(knapsack01DP_v2(v, w, V));

        System.out.println("#### Unbound ####");
        System.out.println(knapsackUnbound(v, w, V, 0));
        System.out.println(knapsackUnboundDP_v1(v, w, V));
        System.out.println(knapsackUnboundDP_v2(v, w, V));
        System.out.println(knapsackUnboundDP_v3(v, w, V));
    }

    public static int knapsack01(int[] v, int[] w, int rest, int index) {
        if (rest == 0 || index == v.length) {
            return 0;
        }
        int o0 = knapsack01(v, w, rest, index + 1);
        int o1 = 0;
        if (rest >= v[index]) {
            o1 = knapsack01(v, w, rest - v[index], index + 1) + w[index];
        }
        return Math.max(o0, o1);
    }

    public static int knapsack01DP_v1(int[] v, int[] w, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]);
                }
            }
        }
        return dp[0][V];
    }

    public static int knapsack01DP_v2(int[] v, int[] w, int V) {
        int[] dp = new int[V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = V; j >= 0; j--) {
                if (j >= v[i]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            }
        }
        return dp[V];
    }

    public static int knapsackUnbound(int[] v, int[] w, int rest, int index) {
        if (rest == 0 || index == v.length) {
            return 0;
        }
        int o = 0;
        for (int i = 0; i * v[index] <= rest; i++) {
            o = Math.max(o, knapsackUnbound(v, w, rest - i * v[index], index + 1) + i * w[index]);
        }
        return o;
    }

    public static int knapsackUnboundDP_v1(int[] v, int[] w, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = 0; j <= V; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[0][V];
    }

    public static int knapsackUnboundDP_v2(int[] v, int[] w, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }
        return dp[0][V];
    }

    public static int knapsackUnboundDP_v3(int[] v, int[] w, int V) {
        int[] dp = new int[V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            }
        }
        return dp[V];
    }
}
