package AC3.A1;

import java.util.Scanner;

public class A278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = find(nums, n, V);
        System.out.println(res);

    }

    static int find(int[] nums, int n, int V) {
        int[] dp = new int[V + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[V];
    }
}
