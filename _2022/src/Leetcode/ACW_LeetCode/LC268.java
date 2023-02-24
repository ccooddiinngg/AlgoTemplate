package Leetcode.ACW_LeetCode;

public class LC268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] == n) {
                return j;
            }
        }
        return n;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
