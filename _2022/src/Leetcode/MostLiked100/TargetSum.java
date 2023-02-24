package Leetcode.MostLiked100;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] cache = new int[nums.length][2 * sum + 1];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return helper(nums, 0, 0, cache, sum, target);
    }

    public int helper(int[] nums, int index, int rest, int[][] cache, int sum, int target) {
        if (index == nums.length && rest == target) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        if (cache[index][rest + sum] != Integer.MAX_VALUE) {
            return cache[index][rest + sum];
        }
        int minus = helper(nums, index + 1, rest - nums[index], cache, sum, target);
        int plus = helper(nums, index + 1, rest + nums[index], cache, sum, target);

        cache[index][rest + sum] = minus + plus;
        return minus + plus;
    }

    //!TODO dp solution
}
