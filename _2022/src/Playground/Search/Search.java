package Playground.Search;

import org.junit.jupiter.api.Test;

public class Search {
    public int leftBound(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public int rightBound(int[] nums, int target) {
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
        return i;
    }

    @Test
    void test() {
        int[] nums = {1, 4, 6, 12, 100, 102};
        int target = 4;
        System.out.println(leftBound(nums, target));
        System.out.println(rightBound(nums, target));
    }
}
