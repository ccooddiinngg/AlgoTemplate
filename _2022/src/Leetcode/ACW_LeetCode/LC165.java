package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC165 {
    public int compareVersion(String version1, String version2) {
        int[] nums1 = toIntArray(version1);
        int[] nums2 = toIntArray(version2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int i = 0;
        while (i < nums1.length || i < nums2.length) {
            int num1 = i < nums1.length ? nums1[i] : 0;
            int num2 = i < nums2.length ? nums2[i] : 0;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
        }
        return 0;

    }

    int[] toIntArray(String ver) {
        String[] v = ver.split("\\.");
        int[] nums = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            nums[i] = Integer.parseInt(v[i]);
        }
        return nums;
    }

    @Test
    void test() {
        String ver1 = "1.1";
        String ver2 = "0.1";
        System.out.println(compareVersion(ver1, ver2));
    }
}
