package Leetcode.ACW_LeetCode;

public class LC55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while (idx < n - 1) {
            int t = -1;
            //i: next step
            for (int i = idx; i <= idx + nums[idx]; i++) {
                if (i >= n - 1) return true;
                if (t == -1 || i + nums[i] > t + nums[t]) {
                    t = i;
                }
            }
            //if next step can't go further
            if (t + nums[t] <= idx + nums[idx]) return false;
            idx = t;
        }
        return true;
    }
}
