package tag.DynamicProgramming;

public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        cache = new int[n + 1];
        return bt(n);
    }

    int[] cache;

    boolean bt(int n) {
        if (cache[n] != 0) return cache[n] == 1;
        for (int i = 1; i <= n; i++) {
            int ii = i * i;
            if (ii > n) break;
            if (ii == n || !bt(n - ii)) {
                cache[n] = 1;
                return true;
            }
        }
        cache[n] = 2;
        return false;
    }

    
    /*DP*/
    public boolean winnerSquareGame1(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int jj = j * j;
                if (jj > i) break;
                if (jj == i || !dp[i - jj]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
