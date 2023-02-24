package Leetcode.Offer;

public class O03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            i++;
        }
        return -1;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
