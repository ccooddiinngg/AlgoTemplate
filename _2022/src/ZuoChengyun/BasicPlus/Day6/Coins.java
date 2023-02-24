package ZuoChengyun.BasicPlus.Day6;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {
    public static int find(int[] coins, int index, int rest, Map<Integer, Integer> path, List<Map<Integer, Integer>> list) {
        if (rest == 0) {
            list.add(path);
            return 1;
        }
        if (index >= coins.length) return 0;

        int v = 0;
        for (int i = 0; i * coins[index] <= rest; i++) {
            path.put(coins[index], i);
            Map<Integer, Integer> next = new HashMap<>(path);
            v += find(coins, index + 1, rest - i * coins[index], next, list);
        }
        return v;
    }

    public static int findDP(int[] coins, int target) {
        int[][] dp = new int[coins.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
//
//        for (int i = dp.length - 2; i >= 0; i--) {
//            for (int j = 1; j < dp[0].length; j++) {
//                for (int k = 0; k * coins[i] <= j; k++) {
//                    dp[i][j] += dp[i + 1][j - k * coins[i]];
//                }
//            }
//        }
//
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[0][target];
    }

    @Test
    void test() {
        int[] coins = {3, 5, 10, 2};
        int target = 200;
        List<Map<Integer, Integer>> list = new ArrayList<>();
        System.out.println(find(coins, 0, target, new HashMap<>(), list));
        for (Map<Integer, Integer> map : list) {
            System.out.println(map);
        }

        //dp
        int dp = findDP(coins, target);
        System.out.println(dp);
    }
}
