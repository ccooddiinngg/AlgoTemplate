package tag.BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int i = 0;
        int j = m;
        while (i <= j) {
            int mid1 = i + j >> 1;
            int mid2 = (m + n) / 2 - mid1;
            int l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < m ? nums1[mid1] : Integer.MAX_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = mid2 < n ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 > r2) {
                j = mid1;
            } else if (l2 > r1) {
                i = mid1 + 1;
            } else {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            }
        }
        return -1;
    }
}
