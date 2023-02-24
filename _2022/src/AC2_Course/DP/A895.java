package AC2_Course.DP;

import java.util.Scanner;

public class A895 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int t = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > dp[t]) {
                    t = j;
                }
            }
            dp[i] = dp[t] + 1;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
