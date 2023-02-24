package Leetcode.ACW_LeetCode;

public class LC137 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i & 1) == 1 ? 1:0;
            }
        }

        for (int i = 0; i < count.length; i++) {
            count[i] %= 3;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] == 1) res += 1 << i;
        }
        return res;
    }
}
