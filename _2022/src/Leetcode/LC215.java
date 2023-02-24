package Leetcode;

import org.junit.jupiter.api.Test;

public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int idx = partition(nums, i, j);
            if (idx < n - k) {
                i = idx + 1;
            } else {
                j = idx;
            }
        }
        return nums[i];
    }

    int partition(int[] nums, int l, int r) {
        int mid = nums[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (nums[++i] < mid) ;
            while (nums[--j] > mid) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    void test() {
        int[] nums = {1, 2, 3, 2, 1, 4, 1};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
