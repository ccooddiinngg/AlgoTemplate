package Leetcode.ACW_LeetCode;

public class LC45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int step = 0;
        while (idx < n - 1) {
            //find the longest next step in current range
            int max = -1;
            for (int i = 1; i <= nums[idx]; i++) {
                if (idx + i >= n - 1) {
                    max = n - 1;
                    break;
                }
                if (max == -1 || idx + i + nums[idx + i] > max + nums[max]) {
                    max = idx + i;
                }
            }
            idx = max;
            step++;
        }
        return step;
    }
}
