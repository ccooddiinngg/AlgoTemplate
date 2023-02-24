package Leetcode.Offer;

public class O62 {
//    public int lastRemaining(int n, int m) {
//        int[] dp = new int[n + 1];
//        //dp[1] = 0
//        for (int i = 2; i < n + 1; i++) {
//            dp[i] = (dp[i - 1] + m) % i;
//        }
//        return dp[n];
//    }

    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i < n + 1; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
