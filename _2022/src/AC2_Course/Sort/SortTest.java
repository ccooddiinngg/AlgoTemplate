package AC2_Course.Sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTest {
    Sort quickSort = new QuickSort();
    Sort mergeSort = new MergeSort();
    Sort quickSortMod = new QuickSortMod();
    int[] nums;

    public SortTest() {
        int n = 9999999;
        int len = 9999999;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * len);
        }
    }

    public void test(Sort sort) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int[] nums2 = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums1);
        sort.sort(nums2);
        Assertions.assertArrayEquals(nums1, nums2);
    }

    @Test
    void testQuickSort() {
        test(quickSort);
    }

    @Test
    void testMergeSort() {
        test(mergeSort);
    }

    @Test
    void testQuickSortMod() {
        test(quickSortMod);
    }
}