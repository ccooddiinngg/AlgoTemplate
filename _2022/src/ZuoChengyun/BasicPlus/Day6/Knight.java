package ZuoChengyun.BasicPlus.Day6;

import org.junit.jupiter.api.Test;

public class Knight {
    public static int play(int M, int N, int x, int y, int steps, int X, int Y) {
        if (steps == 0) {
            return x == X && y == Y ? 1 : 0;
        }
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return 0;
        }
        int v = 0;
        v += play(M, N, x + 2, y + 1, steps - 1, X, Y);
        v += play(M, N, x - 2, y + 1, steps - 1, X, Y);
        v += play(M, N, x + 2, y - 1, steps - 1, X, Y);
        v += play(M, N, x - 2, y - 1, steps - 1, X, Y);
        v += play(M, N, x + 1, y + 2, steps - 1, X, Y);
        v += play(M, N, x - 1, y + 2, steps - 1, X, Y);
        v += play(M, N, x + 1, y - 2, steps - 1, X, Y);
        v += play(M, N, x - 1, y - 2, steps - 1, X, Y);
        return v;
    }

    //starts at x,y ,ends at X,Y
    public static int playDP(int M, int N, int x, int y, int S, int X, int Y) {
        int[][][] dp = new int[M][N][S + 1];
        dp[x][y][0] = 1;
        for (int k = 1; k < dp[0][0].length; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int v = 0;
                    v += valid(i + 2, j + 1, M, N) ? dp[i + 2][j + 1][k - 1] : 0;
                    v += valid(i + 2, j - 1, M, N) ? dp[i + 2][j - 1][k - 1] : 0;
                    v += valid(i - 2, j + 1, M, N) ? dp[i - 2][j + 1][k - 1] : 0;
                    v += valid(i - 2, j - 1, M, N) ? dp[i - 2][j - 1][k - 1] : 0;
                    v += valid(i + 1, j + 2, M, N) ? dp[i + 1][j + 2][k - 1] : 0;
                    v += valid(i + 1, j - 2, M, N) ? dp[i + 1][j - 2][k - 1] : 0;
                    v += valid(i - 1, j + 2, M, N) ? dp[i - 1][j + 2][k - 1] : 0;
                    v += valid(i - 1, j - 2, M, N) ? dp[i - 1][j - 2][k - 1] : 0;
                    dp[i][j][k] = v;
                }
            }
        }
        return dp[X][Y][S];
    }

    private static boolean valid(int x, int y, int M, int N) {
        return !(x < 0 || x >= M || y < 0 || y >= N);

    }

    @Test
    void test() {
        int M = 9;
        int N = 10;
        int S = 10;
        int x = 0;
        int y = 0;
        int X = 7;
        int Y = 7;
        System.out.println(play(M, N, x, y, S, X, Y));
        System.out.println(playDP(M, N, x, y, S, X, Y));
    }
}
