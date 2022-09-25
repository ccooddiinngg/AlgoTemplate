package tag.Greedy;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[m - 1] = 0;

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                dp[i] = Math.min(dp[i], dp[Math.min(i + j, m - 1)] + 1);
            }
        }
        return dp[0];
    }

    //bt(nums, 0)
    int bt(int[] nums, int idx) {
        if (nums[idx] == 0) return Integer.MAX_VALUE;
        if (idx == nums.length - 1) return 0;
        if (idx + nums[idx] >= nums.length - 1) return 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            min = Math.min(min, bt(nums, idx + i));
        }
        return min + 1;
    }

    /*Greedy*/
    public int jump1(int[] nums) {
        int m = nums.length;
        int i = 0;
        int step = 0;
        while (i < m - 1) {
            if (i + nums[i] >= m - 1) {
                step++;
                break;
            }
            int k = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[i + j] + i + j > nums[i + k] + i + k) {
                    k = j;
                }
            }
            i += k;
            step++;
        }
        return step;
    }
}
