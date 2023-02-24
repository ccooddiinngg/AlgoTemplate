package Leetcode.ACW_LeetCode;

public class LC69 {
    public int mySqrt(int x) {
        int i = 0;
        int j = x;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (mid > x / mid) {
                j = mid - 1;
            }else {
                i = mid;
            }
        }
        return i;
    }
}
