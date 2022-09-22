package tag.DynamicProgramming;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        cache = new int[1 << maxChoosableInteger];
        //state: 1010 -> 2, 4 used
        return bt(maxChoosableInteger, desiredTotal, 0, 0);
    }

    int[] cache;

    public boolean bt(int maxChoosableInteger, int desiredTotal, int sum, int state) {
        if (cache[state] != 0) return cache[state] == 1;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state >> i & 1) == 0) {
                if (i + 1 + sum >= desiredTotal) {
                    cache[state] = 1;
                    return true;
                }
                state += 1 << i;
                boolean next = bt(maxChoosableInteger, desiredTotal, i + 1 + sum, state);
                state -= 1 << i;
                if (!next) {
                    cache[state] = 1;
                    return true;
                }
            }
        }
        cache[state] = 2;
        return false;
    }
}
