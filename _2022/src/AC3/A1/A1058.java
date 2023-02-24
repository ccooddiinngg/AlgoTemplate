package AC3.A1;

import java.util.Scanner;

public class A1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        int max = bt(nums, n, 0, false, false);
//        System.out.println(max);

        int max = getMax(nums, n);
        System.out.println(max);
    }

    static int bt(int[] nums, int n, int day, boolean hold, boolean sold) {
        if (day == n) {
            return 0;
        }
        int wait = 0;
        wait = bt(nums, n, day + 1, hold, false);
        int sell = 0;
        if (hold) {
            sell = nums[day] + bt(nums, n, day + 1, false, true);
        }
        int buy = 0;
        if (!hold && !sold) {
            buy = -nums[day] + bt(nums, n, day + 1, true, false);
        }
        return Math.max(wait, Math.max(buy, sell));
    }

    static int getMax(int[] nums, int n) {
        int[][][] dp = new int[n + 1][2][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 2; l++) {
                    dp[i][j][l] = dp[i + 1][j][0];
                    if (j == 1) {
                        dp[i][j][l] = Math.max(dp[i][j][l], dp[i + 1][0][1] + nums[i]);
                    }
                    if (j == 0 && l == 0) {
                        dp[i][j][l] = Math.max(dp[i][j][l], dp[i + 1][1][0] - nums[i]);
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
