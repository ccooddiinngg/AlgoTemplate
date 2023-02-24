package Leetcode.ACW_LeetCode;

public class LC486 {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int score = bt1(nums, 0, nums.length - 1);
        return score * 2 >= sum;
    }

    int bt1(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        return Math.max(bt2(nums, l + 1, r) + nums[l], bt2(nums, l, r - 1) + nums[r]);
    }

    int bt2(int[] nums, int l, int r) {
        if (l == r) return 0;
        return Math.min(bt1(nums, l + 1, r), bt1(nums, l, r - 1));
    }
}
