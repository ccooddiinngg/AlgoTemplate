package tag.BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianOfTwoSortedArraysTest {
    MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

    @Test
    void test() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        Double num = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.0, num);
    }

}