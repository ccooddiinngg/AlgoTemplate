package Leetcode.ACW_LeetCode;

public class LC526 {
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = i;
        }
        return bt(nums, 1);
    }

    int bt(int[] nums, int idx) {
        if (idx == nums.length) return 1;
        int res = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] % idx == 0 || idx % nums[i] == 0) {
                swap(nums, i, idx);
                res += bt(nums, idx + 1);
                swap(nums, i, idx);
            }
        }
        return res;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
