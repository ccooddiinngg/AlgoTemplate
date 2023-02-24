package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

public class LC33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            //target at left part
            if (target > nums[r]) {
                //mid at left part
                if (nums[mid] > nums[r]) {
                    if (nums[mid] > target) {
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
                //mid at right part
                else {
                    r = mid - 1;
                }
            }
            //target at right part
            else {
                //mid at right part
                if (nums[mid] <= nums[r]) {
                    if (nums[mid] > target) {
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
                //mid at left part
                else {
                    l = mid + 1;
                }
            }
        }
        return nums[l] == target ? l:-1;
    }

    @Test
    void test() {
        int[] nums = {4,5,6,7,8,1,2,3};
        int target = 8;
        System.out.println(search(nums, target));
    }

}
