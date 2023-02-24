package ZuoChengyun.Middle.Day9;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class LowestBudget {

    //cost [x,y,x] contribute [+2, *2, -2] , (start, end) are even numbers.
    public static int find(int x, int y, int z, int start, int current, int end, int spend, int[][] cache) {
        if (spend > x * (end - start) / 2 || current < 0 || current > end * 2) {
            return Integer.MAX_VALUE;
        }
        if (cache[current][spend] != 0) {
            return cache[current][spend];
        }
        if (current == end) {
            return spend;
        }
        int v1 = find(x, y, z, start, current + 2, end, spend + x, cache);
        int v2 = find(x, y, z, start, current * 2, end, spend + y, cache);
        int v3 = find(x, y, z, start, current - 2, end, spend + z, cache);
        int v = Math.min(v1, Math.min(v2, v3));
        cache[current][spend] = v;
        return v;
    }

    public static int findDP(int start, int end, int x, int y, int z) {
        int limit = x * (end - start) / 2;
        int[][] dp = new int[end * 2 + 1][limit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == end) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            if (i == end) {
                continue;
            }
            for (int j = dp[0].length - 1; j >= 0; j--) {
                int v1 = i + 2 >= dp.length || j + x >= limit ? Integer.MAX_VALUE : dp[i + 2][j + x];
                int v2 = i * 2 >= dp.length || j + y >= limit ? Integer.MAX_VALUE : dp[i * 2][j + y];
                int v3 = i - 2 < 0 || j + z >= limit ? Integer.MAX_VALUE : dp[i - 2][j + z];

                dp[i][j] = Math.min(v1, Math.min(v2, v3));
            }
        }
//        Utils.print2DArray(dp);
        return dp[start][0];
    }

    @Test
    void test() {
        int x = 5;
        int y = 4;
        int z = 3;
        int start = 0;
        int end = 100;
        int[][] cache = new int[end * 2 + 1][(end - start) / 2 * x + 1];
        System.out.println(find(x, y, z, start, start, end, 0, cache));

        System.out.println(findDP(start, end, x, y, z));
    }
}
