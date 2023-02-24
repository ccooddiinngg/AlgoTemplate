package Leetcode.ACW_LeetCode;

public class LC162 {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] > nums[mid + 1]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
