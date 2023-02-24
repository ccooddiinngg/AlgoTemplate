package Leetcode.Coding_Interview_6.C17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class S14Test {
    S14 s14 = new S14();
    S14a s14a = new S14a();

    @Test
    void test() {
        int[] nums = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(Arrays.toString(s14.smallestK(nums, k)));
    }

    @Test
    void testQuickSort() {
        int[] nums1 = {4, 3, 1, 1, 2, 4, 2, 2, 5, 1};
        System.out.println(s14.partition(nums1, 0, nums1.length - 1));
        System.out.println(Arrays.toString(nums1));
        System.out.println("---");
        int[] nums2 = {4, 3, 1, 1, 2, 4, 2, 2, 5, 1};
        System.out.println(Arrays.toString(s14a.partition(nums2, 0, nums1.length - 1)));
        System.out.println(Arrays.toString(nums2));
    }
}