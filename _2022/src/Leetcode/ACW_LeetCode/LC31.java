package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC31 {
    //以排列 [4,5,2,6,3,1] 为例：
    //我们能找到的符合条件的一对「较小数」与「较大数」的组合为 2 与 3，满足「较小数」尽量靠右，而「较大数」尽可能小。
    //当我们完成交换后排列变为 [4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6]。

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = n - 1;
        int right = n - 1;
        while (left >= 0) {
            boolean found = false;
            for (int i = n - 1; i > left; i--) {
                if (nums[left] < nums[i]) {
                    found = true;
                    right = i;
                    break;
                }
            }
            if (found) break;
            left--;
        }
        if (left == -1) {
            Arrays.sort(nums);
            return;
        }
        swap(nums, left, right);

        for (int i = 0; i < (n - left) / 2; i++) {
            swap(nums, left + 1 + i, n - 1 - i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    void test() {
        int[] nums = {4, 5, 2, 6, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
