package Leetcode.ACW_LeetCode;

public class LC371 {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }
}
