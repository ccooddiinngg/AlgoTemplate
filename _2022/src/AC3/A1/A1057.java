package AC3.A1;

import java.util.Scanner;

public class A1057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        int max = bt(nums, n, k, 0, false);
//        System.out.println(max);

        int max = getMax(nums, n, k);
        System.out.println(max);
    }

    //brute force
    static int bt(int[] nums, int n, int k, int idx, boolean canSell) {
        if (k == 0 || idx == n) {
            return 0;
        }

        int profit = 0;
        if (canSell) {
            profit = nums[idx] + bt(nums, n, k - 1, idx + 1, false);
        } else {
            profit = -nums[idx] + bt(nums, n, k, idx + 1, true);
        }
        int wait = bt(nums, n, k, idx + 1, canSell);

        return Math.max(wait, profit);
    }

    static int getMax(int[] nums, int n, int k) {
        int[][][] dp = new int[n + 1][k + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i + 1][j][1] - nums[i], dp[i + 1][j][0]);
                dp[i][j][1] = Math.max(dp[i + 1][j - 1][0] + nums[i], dp[i + 1][j][1]);

            }
        }

        return dp[0][k][0];
    }
}
