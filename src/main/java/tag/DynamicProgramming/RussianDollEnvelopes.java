package tag.DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int idx = find(dp, envelopes[i][1]);
            dp[idx] = envelopes[i][1];
        }
        return find(dp, Integer.MAX_VALUE);
    }

    int find(int[] dp, int num) {
        int i = 0;
        int j = dp.length;
        while (i < j) {
            int mid = i + j >> 1;
            if (dp[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

}
