package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int m = nums.length;
        int rotation = helper(nums, 0, m - 1);

        int i = 0;
        int j = m;
        if (target > nums[m - 1]) {
            j = rotation;
        } else {
            i = rotation;
        }
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public int helper(int[] nums, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    void test() {
        int[] nums = {1, 3};
        System.out.println(search(nums, 1));
    }

}
