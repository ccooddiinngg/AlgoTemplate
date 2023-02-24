package Leetcode.Offer;

public class O21 {
    public int[] exchange(int[] nums) {
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] % 2 == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
