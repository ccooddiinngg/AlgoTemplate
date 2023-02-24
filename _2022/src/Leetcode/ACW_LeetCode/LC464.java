package Leetcode.ACW_LeetCode;

public class LC464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        cache = new int[1 << maxChoosableInteger];
        return bt(maxChoosableInteger, desiredTotal, 0);
    }

    int[] cache;

    boolean bt(int max, int rest, int used) {
        if (cache[used] != 0) return cache[used] == 1;
        for (int i = 0; i < max; i++) {
            if ((used >> i & 1) == 0) {
                if (rest <= i + 1) {
                    cache[used] = 1;
                    return true;
                }
                used += 1 << i;
                boolean win = bt(max, rest - (i + 1), used);
                used -= 1 << i;
                if (!win) {
                    cache[used] = 1;
                    return true;
                }
            }
        }
        cache[used] = 2;
        return false;
    }
}
