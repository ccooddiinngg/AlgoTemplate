package ZuoChengyun.Basic.Day15;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class BackpackDP {

    public static int backpackDP(int[] weights, int[] values, int MAX) {
        int[][] dp = new int[weights.length + 1][MAX + 1];

        for (int i = weights.length - 1; i >= 0; i--) {
            for (int j = 0; j < MAX + 1; j++) {
                int v0 = dp[i + 1][j];
                int v1 = 0;
                if (j >= weights[i]) {
                    v1 = dp[i + 1][j - weights[i]] + values[i];
                }
                dp[i][j] = Math.max(v0, v1);
            }
        }
        Utils.print2DArray(dp);
        return dp[0][MAX];
    }

    @Test
    void backpackDPTest() {
        int[] weights = {1, 4, 2, 3};
        int[] values = {3, 11, 3, 7};
        int MAX = 6;

        int totalValue = backpackDP(weights, values, MAX);
        System.out.println(totalValue);

    }
}
