package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int half = m + n >> 1;
        int i = 0;
        int j = m;
        while (i <= j) {
            int mid1 = i + j >> 1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int mid2 = half - mid1;
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            }
            if (l1 > r2) {
                j = mid1;
            } else {
                i = mid1 + 1;
            }
        }
        return 0.0;
    }

    @Test
    void test() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}