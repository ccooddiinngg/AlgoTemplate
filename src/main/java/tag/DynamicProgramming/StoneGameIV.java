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
}
