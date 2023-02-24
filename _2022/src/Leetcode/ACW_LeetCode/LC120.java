package Leetcode.ACW_LeetCode;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        // System.out.println(Arrays.toString(dp[m - 1]));
        int min = Integer.MAX_VALUE;
        for (int val: dp[m - 1]) {
            min = Math.min(min, val);
        }
        return min;
    }
}
