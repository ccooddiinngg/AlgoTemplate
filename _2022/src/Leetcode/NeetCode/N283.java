package Leetcode.NeetCode;


//@@ two pointers
public class N283 {
    public void moveZeroes(int[] nums) {
        int m = nums.length;
        int p = 0;
        while (p < m && nums[p] != 0) {
            p++;
        }

        for (int i = p + 1; i < m; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[p];
                nums[p] = t;
                p++;
            }
        }
    }
}
