package Leetcode.ACW_LeetCode;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    int findLeft(int[] nums, int tar) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] >= tar) {
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return nums[i] == tar ? i:-1;
    }

    int findRight(int[] nums, int tar) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j + 1>> 1;
            if (nums[mid] <= tar) {
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        return nums[i] == tar ? i:-1;
    }
}
