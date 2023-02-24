package ZuoChengyun.Basic.Day15;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinsDP {
    public static int bruteforce(int[] coins, int rest, int index, String path, List<String> list) {
        if (rest == 0) {
            list.add(path);
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; rest - i * coins[index] >= 0; i++) {
            count += bruteforce(coins, rest - i * coins[index], index + 1, path, list);
        }
        return count;
    }

    public static int coinsCache(int[] coins, int rest, int index, int[][] cache) {
        if (cache[index][rest] != -1) {
            return cache[index][rest];
        }

        if (index == coins.length) {
            cache[index][rest] = rest == 0 ? 1 : 0;
            return cache[index][rest];
        }
        int count = 0;
        for (int i = 0; rest - i * coins[index] >= 0; i++) {
            count += coinsCache(coins, rest - i * coins[index], index + 1, cache);
        }
        cache[index][rest] = count;
        return count;
    }

    public static int coinsDP(int[] coins, int N) {
        int[][] dp = new int[coins.length + 1][N + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 0; j - k * coins[i] >= 0; k++) {
                    dp[i][j] += dp[i + 1][j - k * coins[i]];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[0][N];
    }

    public static int coinsDPPlus(int[] coins, int N) {
        int[][] dp = new int[coins.length + 1][N + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j < N + 1; j++) {
                //not using this coin
                dp[i][j] = dp[i + 1][j];
                //using this coin
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[0][N];
    }

    public static int leastCoins(int[] coins, int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[N];
    }

    @Test
    void coinsDPTest() {
        int[] coins = {10, 2, 5, 1};
        int N = 20;

        /*bruteforce*/
        List<String> list = new ArrayList<>();
        int count = bruteforce(coins, N, 0, "", list);
        System.out.println(count);
//        System.out.println(list);

        /*cache*/
        int[][] cache = new int[coins.length + 1][N + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        int coinCache = coinsCache(coins, N, 0, cache);
        System.out.println(coinCache);
        Utils.print2DArray(cache);

        /*dp*/
        int dp = coinsDP(coins, N);
        System.out.println(dp);

        /*dpPlus*/
        int dpPlus = coinsDPPlus(coins, N);
        System.out.println(dpPlus);

        /*dpPlusPlus*/
        int dpPlusPlus = leastCoins(coins, N);
        System.out.println(dpPlusPlus);
    }
}
