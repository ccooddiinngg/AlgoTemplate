package Leetcode.Offer;

public class O53_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        if (left == -1) return 0;
        return right - left + 1;
    }

    int findLeft(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i] == target ? i : -1;
    }

    int findRight(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (nums[mid] <= target) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return nums[i] == target ? i : -1;
    }
}
