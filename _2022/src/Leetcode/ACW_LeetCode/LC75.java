package Leetcode.ACW_LeetCode;

public class LC75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] < 1) {
                swap(nums, i, l);
                i++;
                l++;
            }else if (nums[i] == 1) {
                i++;
            }else {
                swap(nums, i, r);
                r--;
            }
        }
    }

    void swap(int[] nums, int i , int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
