package Leetcode.Coding_Interview_6.C17;

public class S09 {
    public int getKthMagicNumber(int k) {
        int[] t = new int[3];
        int p1 = 0, p2 = 0, p3 = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            t[0] = dp[p1] * 3;
            t[1] = dp[p2] * 5;
            t[2] = dp[p3] * 7;
            int min = Math.min(Math.min(t[0], t[1]), t[2]);
            if (t[0] == min) p1++;
            if (t[1] == min) p2++;
            if (t[2] == min) p3++;
            dp[i] = min;
        }
        return dp[k - 1];
    }
}


