package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = helper(nums, left, right);
            if (index == nums.length - k) {
                break;
            } else if (index < nums.length - k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[nums.length - k];
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int seed = nums[right];
        int min = left;
        int max = right;
        int p = left;
        while (p <= max) {
            if (nums[p] < seed) {
                swap(nums, p, min);
                min++;
                p++;
            } else if (nums[p] == seed) {
                p++;
            } else {
                swap(nums, p, max);
                max--;
            }
        }
        return min;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
