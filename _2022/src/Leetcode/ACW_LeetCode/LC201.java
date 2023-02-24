package Leetcode.ACW_LeetCode;

public class LC201 {
    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        int i = 1 << 30;
        while (i > 0) {
            if ((left & i) == (right & i)) {
                res += left & i;
            } else {
                break;
            }
            i >>= 1;
        }
        return res;
    }

}
