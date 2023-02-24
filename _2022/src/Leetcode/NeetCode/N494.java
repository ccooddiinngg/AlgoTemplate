package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


//@@ use int[][] cache
public class N494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] cache = new int[nums.length][sum * 2 + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return helper(nums, 0, target, 0, cache, sum);
    }

    public int helper(int[] nums, int index, int target, int path, int[][] cache, int sum) {
        if (index == nums.length) {
            if (path == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (cache[index][path + sum] != -1) {
            return cache[index][path + sum];
        }
        int count = helper(nums, index + 1, target, path + nums[index], cache, sum) +
                helper(nums, index + 1, target, path - nums[index], cache, sum);

        cache[index][path + sum] = count;
        return count;
    }

    @Test
    void test() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
