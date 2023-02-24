package ZuoChengyun.BasicPlus.Day5;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

public class RobotMovement {

    public static int move(int N, int end, int steps, int pos) {
        if (steps == 0) {
            return pos == end ? 1 : 0;
        }
        int v = 0;
        if (pos == 1) {
            v += move(N, end, steps - 1, pos + 1);
        } else if (pos == N) {
            v += move(N, end, steps - 1, pos - 1);
        } else {
            v += move(N, end, steps - 1, pos - 1);
            v += move(N, end, steps - 1, pos + 1);
        }
        return v;
    }

    public static int moveDP(int N, int end, int K, int pos) {
        int[][] dp = new int[K + 1][N + 1];
        dp[0][pos] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] += dp[i - 1][j + 1];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[K][end];
    }

    @Test
    void test() {
        int N = 4;
        int start = 2;
        int end = 2;
        int K = 4;
        System.out.println(move(N, end, K, start));
        System.out.println(moveDP(N, end, K, start));
    }
}
