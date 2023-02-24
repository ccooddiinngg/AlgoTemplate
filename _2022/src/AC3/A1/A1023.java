package AC3.A1;

import java.util.Scanner;

public class A1023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {10, 20, 50, 100};
        int V = sc.nextInt();
        int res = find(nums, nums.length, V);
        System.out.println(res);
    }

    static int find(int[] nums, int n, int V) {
        int[] dp = new int[V + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j < V + 1; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[V];
    }
}
