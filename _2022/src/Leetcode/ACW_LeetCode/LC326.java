package Leetcode.ACW_LeetCode;

public class LC326 {
//    n > 0 && 1162261467 % n == 0;

    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}
