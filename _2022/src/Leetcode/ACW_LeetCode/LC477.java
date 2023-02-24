package Leetcode.ACW_LeetCode;

public class LC477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
            res += count0 * count1;
        }

        return res;
    }
}
