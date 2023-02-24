package ZuoChengyun.Basic.Day14;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Robot {

    public static int run(int N, int K, int P, int i, int pos, int[][] cache) {
        if (i == K) {
            return pos == P ? 1 : 0;
        }
        if (cache[i][pos] != -1) {
            return cache[i][pos];
        }
        int oLeft = 0;
        int oRight = 0;
        if (pos == 1) {
            oRight = run(N, K, P, i + 1, pos + 1, cache);
        } else if (pos == N) {
            oLeft = run(N, K, P, i + 1, pos - 1, cache);
        } else {
            oRight = run(N, K, P, i + 1, pos + 1, cache);
            oLeft = run(N, K, P, i + 1, pos - 1, cache);
        }
        cache[i][pos] = oLeft + oRight;
        return oLeft + oRight;
    }

    @Test
    void runTest() {
        int N = 5, M = 2, K = 10, P = 2;
        int[][] cache = new int[K + 1][N + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        int run = run(N, K, P, 0, M, cache);
        System.out.println(run);
        for (int[] arr : cache) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int dpRun2D(int N, int K, int P, int M) {
        int[][] dp = new int[K + 1][N + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        dp[0][M] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j == 1) {
                    dp[i][1] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][N] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        Utils.print2DArray(dp);
        return dp[K][P];
    }

    public static int dpRun1D(int N, int K, int P, int M) {
        int[] dp = new int[N + 1];
        dp[M] = 1;
        int[] temp = new int[N + 1];
        for (int i = 1; i < K + 1; i++) {
            temp[1] = dp[2];
            temp[N] = dp[N - 1];
            for (int j = 2; j < N; j++) {
                temp[j] = dp[j - 1] + dp[j + 1];
            }
            System.arraycopy(temp, 0, dp, 0, N + 1);
        }

        return dp[P];
    }


    @Test
    void dpRunTest() {
        int N = 5, M = 2, K = 11, P = 3;
        int dpRun2D = dpRun2D(N, K, P, M);
        int dpRun1D = dpRun1D(N, K, P, M);
        System.out.println(dpRun2D);
        System.out.println(dpRun1D);
    }

}
