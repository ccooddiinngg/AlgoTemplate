package AC2.A5;

import java.util.Arrays;
import java.util.Scanner;

public class A282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
//        int min = cost(nums, 0, nums.length - 1, preSum);
        int min = minCost(nums, n, preSum);
        System.out.println(min);
    }

    static int minCost(int[] nums, int n, int[] preSum) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i; k < j; k++) {
                    int o = dp[i][k] + dp[k + 1][j] + preSum[j + 1] - preSum[i];
                    dp[i][j] = Math.min(dp[i][j], o);
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][n - 1];
    }

    static int cost(int[] nums, int i, int j, int[] preSum) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int o = cost(nums, i, k, preSum) + cost(nums, k + 1, j, preSum) + preSum[j + 1] - preSum[i];
            min = Math.min(min, o);
        }
        return min;
    }


}
