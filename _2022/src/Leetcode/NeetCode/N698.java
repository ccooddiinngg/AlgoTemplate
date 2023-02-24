package Leetcode.NeetCode;

import java.util.Arrays;

//@@ put in k boxes, SORT first, O(k ^ n)
public class N698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        for (int num : nums) {
            if (num > sum / k) {
                return false;
            }
        }
        int[] count = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }
        return helper(nums, count, 0, sum / k);
    }

    public boolean helper(int[] nums, int[] count, int index, int target) {
        if (index == nums.length) {
            return true;
        }
        boolean b = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] + nums[index] <= target) {
                count[i] += nums[index];
                b = b || (helper(nums, count, index + 1, target));
                count[i] -= nums[index];
            }
        }
        return b;
    }
}
