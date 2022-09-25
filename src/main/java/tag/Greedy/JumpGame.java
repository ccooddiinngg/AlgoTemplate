package tag.Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int m = nums.length;
        int i = 0;
        while (i < m - 1) {
            if (i + nums[i] >= m - 1) break;
            int k = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j + nums[i + j] > i + k + nums[i + k]) {
                    k = j;
                }
            }
            if (k == 0) {
                return false;
            }
            i += k;
        }
        return true;
    }
}
