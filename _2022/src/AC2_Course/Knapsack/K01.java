package AC2_Course.Knapsack;


import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class K01 {
    public int maxValue(int[] value, int[] weight, int V) {
        return helper(value, weight, 0, V);
    }

    public int helper(int[] value, int[] weight, int index, int rest) {
        if (index == value.length) {
            return 0;
        }
        int v0 = helper(value, weight, index + 1, rest);
        int v1 = 0;
        if (rest >= weight[index]) {
            v1 = helper(value, weight, index + 1, rest - weight[index]) + value[index];
        }
        return Math.max(v0, v1);
    }

    /*DP 2D*/
    public int maxValueDP2D(int[] value, int[] weight, int V) {
        int[][] dp = new int[value.length + 1][V + 1];
        Arrays.fill(dp[dp.length - 1], 0);
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - weight[i]] + value[i]);
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[0][V];
    }

    /*DP 1D*/
    public int maxValueDP1D(int[] value, int[] weight, int V) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < value.length; i++) {
            for (int j = dp.length - 1; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[V];
    }

    @Test
    void test() {
        int[] value = {2, 4, 4, 5};
        int[] weight = {1, 2, 3, 4};
        int V = 5;

        assertEquals(8, maxValue(value, weight, V));
        assertEquals(8, maxValueDP2D(value, weight, V));
        assertEquals(8, maxValueDP1D(value, weight, V));
    }


}
