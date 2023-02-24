package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int last = nums.length - 1;
        while (last > 0 && nums[last] <= nums[last - 1]) {
            last--;
        }
        if (last == 0) {
            reverse(nums, 0);
            return;
        }
        int candidate = last;
        while (candidate < nums.length - 1 && nums[candidate + 1] > nums[last - 1]) {
            candidate++;
        }
        swap(nums, last - 1, candidate);
        reverse(nums, last);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        for (int i = 0; i < (nums.length - start) / 2; i++) {
            swap(nums, start + i, nums.length - 1 - i);
        }
    }

    @Test
    void test() {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
