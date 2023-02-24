package Leetcode.ACW_LeetCode;

public class LC260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int i = 0;
        while ((xor >> i & 1) != 1) {
            i++;
        }
        int b0 = 0;
        int b1 = 0;
        for (int num : nums) {
            if ((num >> i & 1) == 0) {
                b0 ^= num;
            } else {
                b1 ^= num;
            }
        }
        return new int[]{b0, b1};
    }
}
