package Leetcode.Coding_Interview_6.C17;

import java.util.Arrays;

public class S08 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        P[] ppl = new P[n];
        for (int i = 0; i < n; i++) {
            ppl[i] = new P(height[i], weight[i]);
        }

        //！sort ppl: h ascend and w descend
        // when find idx, can make sure less w will replace greater w
        Arrays.sort(ppl, (a, b) -> {
            if (a.h == b.h) {
                return b.w - a.w;
            }
            return a.h - b.h;
        });

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int idx = indexOf(dp, ppl[i].w);
            dp[idx] = ppl[i].w;
        }
        int max = indexOf(dp, Integer.MAX_VALUE);

        return max;
    }

    int indexOf(int[] dp, int num) {
        int i = 0;
        int j = dp.length - 1;
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

    class P {
        int h;
        int w;

        public P(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
