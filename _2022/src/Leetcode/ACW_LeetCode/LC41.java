package Leetcode.ACW_LeetCode;

public class LC41 {

//    对于一个长度为 N 的数组，其中没有出现的最小正整数只能在[1,N+1] 中。
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while (idx < n) {
            if (nums[idx] >= 1 && nums[idx] <= n && nums[nums[idx] - 1] != nums[idx]) {
                swap(nums, idx, nums[idx] - 1);
            }else {
                idx++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
