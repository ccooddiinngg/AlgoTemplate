package AC2_Course.Knapsack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

public class K02 {

    public int maxValue(int[] v, int[] w, int V) {
        return helper(v, w, 0, V);
    }

    public int helper(int[] v, int[] w, int index, int rest) {
        if (index == v.length) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i * w[index] <= rest; i++) {
            max = Math.max(max, helper(v, w, index + 1, rest - i * w[index]) + i * v[index]);
        }
        return max;
    }

    /*DP 2D*/
    public int maxValueDP2D1(int[] v, int[] w, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
//        Utils.print2DArray(dp);
        return dp[0][V];
    }

    //not optimised
    public int maxValueDP2D2(int[] v, int[] w, int V) {
        int[][] dp = new int[v.length + 1][V + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                //
                // dp[i][j]        = max( dp[i + 1][j - k * w[i]] + k * v[i] )
                // dp[i][j]        = max( dp[i + 1][j], dp[i + 1][j - w[i]] + v[i], dp[i + 1][j - 2 * w[i]] + 2 * v[i], ...)
                // dp[i][j - w[i]] = max(               dp[i + 1][j - w[i]]       , dp[i + 1][j - 2 * w[i]] + v[i], dp[i + 1][j - 3 * w[i]] + 2 * v[i], ...)
                // dp[i][j]        = max( dp[i + 1][j], dp[i][j - w[i]] + v[i] )
                //
                for (int k = 0; k * w[i] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - k * w[i]] + k * v[i]);
                }

            }
        }
//        Utils.print2DArray(dp);
        return dp[0][V];
    }

    @RepeatedTest(10)
    void test() {
//        int[] w = {1, 2, 3, 4};
//        int[] v = {2, 4, 4, 5};
//        int V = 5;

        Random r = new Random();
        int[] w = new int[10];
        int[] v = new int[10];
        int _w;
        int _v;
        for (int i = 0; i < w.length; i++) {
            _w = r.nextInt(5) + 2;
            w[i] = _w;
            _v = r.nextInt(3) + 2;
            v[i] = _v;
        }
        int V = 30;

        System.out.println(Arrays.toString(w));
        System.out.println(Arrays.toString(v));

        Assertions.assertEquals(maxValueDP2D1(v, w, V), maxValueDP2D2(v, w, V));
    }
}
