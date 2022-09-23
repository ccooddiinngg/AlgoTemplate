package tag.DynamicProgramming;

import java.util.Arrays;

//TODO n^3 -> binary search (log n)*n^2
public class StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        int m = stoneValue.length;
        pre = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            pre[i] = pre[i - 1] + stoneValue[i - 1];
        }
        cache = new int[m + 1][m + 1];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int max = bt(0, m);
//        for (int[] row : cache) {
//            System.out.println(Arrays.toString(row));
//        }
        return max;
    }

    int[] pre;
    int[][] cache;

    int bt(int l, int r) {
        if (l == r - 1) {
            return 0;
        }
        if (cache[l][r] != Integer.MAX_VALUE) return cache[l][r];
        int max = 0;
        for (int i = l + 1; i < r; i++) {
            int left = pre[i] - pre[l];
            int right = pre[r] - pre[i];
            if (left == right) {
                max = Math.max(max, Math.max(left + bt(l, i), right + bt(i, r)));
            } else if (left < right) {
                max = Math.max(max, left + bt(l, i));
            } else {
                max = Math.max(max, right + bt(i, r));
            }
        }
        cache[l][r] = max;
        return max;
    }

    /*DP*/
    public int stoneGameV1(int[] stoneValue) {
        int m = stoneValue.length;
        int[] pre = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            pre[i] = pre[i - 1] + stoneValue[i - 1];
        }
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = i + 2; j < m + 1; j++) {
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    int left = pre[k] - pre[i];
                    int right = pre[j] - pre[k];
                    if (left == right) {
                        max = Math.max(max, Math.max(left + dp[i][k], right + dp[k][j]));
                    } else if (left < right) {
                        max = Math.max(max, left + dp[i][k]);
                    } else {
                        max = Math.max(max, right + dp[k][j]);
                    }
                }
                dp[i][j] = max;
            }
        }

        return dp[0][m];
    }
}
