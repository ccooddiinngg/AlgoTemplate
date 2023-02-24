package ZuoChengyun.BasicPlus.Day5;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class Coins {
    public static int play(int[] coins, int index, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }
        if (index == coins.length) {
            return -1;
        }
        int v0Next = play(coins, index + 1, rest);
        int v1Next = play(coins, index + 1, rest - coins[index]);
        if (v0Next == -1 && v1Next == -1) {
            return -1;
        }
        if (v0Next == -1) {
            return v1Next + 1;
        }
        if (v1Next == -1) {
            return v0Next;
        }
        return Math.min(v0Next, v1Next + 1);
    }

    public static int playDP(int[] coins, int rest) {
        int[][] dp = new int[coins.length + 1][rest + 1];

        //! don't cover column 0
        for (int j = 1; j < dp[0].length; j++) {
            dp[dp.length - 1][j] = -1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                int v0Next = dp[i + 1][j];
                int v1Next;
                if (j < coins[i]) {
                    v1Next = -1;
                } else {
                    v1Next = dp[i + 1][j - coins[i]];
                }
                if (v0Next == -1 && v1Next == -1) {
                    dp[i][j] = -1;
                } else if (v0Next == -1) {
                    dp[i][j] = v1Next + 1;
                } else if (v1Next == -1) {
                    dp[i][j] = v0Next;
                } else {
                    dp[i][j] = Math.min(v0Next, v1Next + 1);
                }

            }
        }
        Utils.print2DArray(dp);
        return dp[0][rest];
    }

    @Test
    void test() {
        int[] coins = {2, 9, 3, 5, 1};
        int target = 10;
        System.out.println(play(coins, 0, target));
        System.out.println(playDP(coins, target));
    }
}
