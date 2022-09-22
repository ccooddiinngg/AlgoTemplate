package tag.DynamicProgramming;

import java.util.Arrays;

public class StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int m = stoneValue.length;
        int M = 3;
        pre = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            pre[i] = pre[i - 1] + stoneValue[i - 1];
        }
        cache = new int[m];
        Arrays.fill(cache, Integer.MIN_VALUE);
        int diff = bt(stoneValue, 0, M);
        return diff >= 0 ? diff > 0 ? "Alice" : "Tie" : "Bob";
    }

    int[] pre;
    int[] cache;

    int bt(int[] stoneValue, int idx, int M) {
        if (idx >= stoneValue.length) return 0;
        if (cache[idx] != Integer.MIN_VALUE) return cache[idx];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= M; i++) {
            int sum = pre[Math.min(idx + i, stoneValue.length)] - pre[idx];
            max = Math.max(max, sum - bt(stoneValue, idx + i, M));
        }
        cache[idx] = max;
        return max;
    }
}
