package Leetcode.ACW_LeetCode;

public class LC462 {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        quickSort(nums, 0, n - 1, mid);
        int count = 0;
        for (int num : nums) {
            count += Math.abs(nums[mid] - num);
        }
        return count;
    }

    void quickSort(int[] nums, int l, int r, int k) {
        while (l < r) {
            int idx = partition(nums, l, r);
            if (idx >= k) {
                r = idx;
            } else {
                l = idx + 1;
            }
        }
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
}
