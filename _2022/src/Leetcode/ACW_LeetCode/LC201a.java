package Leetcode.ACW_LeetCode;

public class LC201a {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            //remove right 1
            right = right & (right - 1);
        }
        return right;
    }
}
