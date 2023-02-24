package Leetcode;

public class N4 {
    public static void main(String[] args) {
        int[] n1 = {1, 2, 6};
        int[] n2 = {3, 4, 5, 6};
        System.out.println(findMedianSortedArrays(n1, n2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int r = m;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int l1 = mid - 1;
            int r1 = mid;
            int l2 = (m + n + 1) / 2 - mid - 1;
            int r2 = l2 + 1;
            int v1l = l1 >= 0 ? nums1[l1] : Integer.MIN_VALUE;
            int v1r = r1 < m ? nums1[r1] : Integer.MAX_VALUE;
            int v2l = l2 >= 0 ? nums2[l2] : Integer.MIN_VALUE;
            int v2r = r2 < n ? nums2[r2] : Integer.MAX_VALUE;
            if (v1l <= v2r && v1r >= v2l) {
                if ((m + n) % 2 == 1) {
                    return Math.max(v1l, v2l);
                } else {
                    return (Math.max(v1l, v2l) + Math.min(v1r, v2r)) / 2.0;
                }
            }
            if (v1l > v2r) {
                r = mid - 1;
            }
            if (v1r < v2l) {
                l = mid + 1;
            }
            //1,2,3 1,2,3,4 1122334
        }
        return 0;
    }
}
