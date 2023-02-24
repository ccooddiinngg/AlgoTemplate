package Leetcode.Coding_Interview_6.C16;

public class S17 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preSum < 0) {
                preSum = nums[i];
            } else {
                preSum += nums[i];
            }
            max = Math.max(max, preSum);
        }
        return max;
    }
}
