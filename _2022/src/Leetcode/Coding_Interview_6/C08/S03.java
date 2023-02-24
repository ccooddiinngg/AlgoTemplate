package Leetcode.Coding_Interview_6.C08;

public class S03 {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
