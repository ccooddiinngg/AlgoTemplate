package tag.DynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int m = nums.length;
        cache = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        return bt(nums, 0, nums.length - 1) >= 0;
    }

    int[][] cache;

    int bt(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        if (cache[i][j] != Integer.MAX_VALUE) return cache[i][j];
        int a = nums[i] - bt(nums, i + 1, j);
        int b = nums[j] - bt(nums, i, j - 1);
        int max = Math.max(a, b);
        cache[i][j] = max;
        return max;
    }
}
