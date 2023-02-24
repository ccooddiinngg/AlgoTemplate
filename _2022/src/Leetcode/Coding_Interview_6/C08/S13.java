package Leetcode.Coding_Interview_6.C08;

import java.util.Arrays;

public class S13 {
    public int pileBox(int[][] box) {

        Arrays.sort(box, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });
        int[] dp = new int[box.length];
        dp[0] = box[0][2];

        for (int i = 1; i < box.length; i++) {
            dp[i] = box[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}
