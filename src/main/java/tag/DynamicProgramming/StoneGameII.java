package tag.DynamicProgramming;

import java.util.Arrays;

public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + piles[i - 1];
        }
        cache = new int[n][n + 1];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int diff = bt(piles, 0, 1);
        return (preSum[n] + diff) / 2;
    }

    int[][] cache;
    //calculate sum from idx to idx + i in piles
    int[] preSum;

    int bt(int[] piles, int idx, int M) {
        if (idx >= piles.length) {
            return 0;
        }
        if (cache[idx][M] != Integer.MAX_VALUE) return cache[idx][M];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= Math.min(piles.length, 2 * M); i++) {
            int sum = preSum[Math.min(idx + i, piles.length)] - preSum[idx];
            max = Math.max(max, sum - bt(piles, idx + i, Math.max(i, M)));
        }
        cache[idx][M] = max;
        return max;
    }
}
