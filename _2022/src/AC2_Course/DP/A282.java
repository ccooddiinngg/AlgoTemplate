package AC2_Course.DP;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/*
4
1 3 5 2
*/
public class A282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] pre = new int[n + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n; i++) {
                int j = Math.min(i + len, n - 1);
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + pre[j + 1] - pre[i], dp[i][j]);
                    }
                }

            }
        }
        Utils.print2DArray(dp);
        System.out.println(dp[0][n - 1]);
    }


    //divide to small problems
    public static int findMin(int[] nums, int[] pre, int i, int j, int[][] cache) {
        if (i == j) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int res = findMin(nums, pre, i, k, cache) + findMin(nums, pre, k + 1, j, cache) + pre[j + 1] - pre[i];
            min = Math.min(min, res);
        }
        cache[i][j] = min;
        return min;
    }

    @Test
    void test() {
//        int[] nums = {1, 3, 5, 2};
        String input = "548 592 715 844 602 857 544 847 423 623 645 384 437 297 891 56 963 272 383 477 791 812 528 479 568 392 925 836 71 337 87 648 20 368 832 957 778 140 870 870 978 473 799 800 461 520 780 678 118 720";
        String[] str = input.split(" ");

        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int[] pre = new int[nums.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int[][] cache = new int[nums.length][nums.length];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int min = findMin(nums, pre, 0, nums.length - 1, cache);
        System.out.println(min);
    }
}
