package Leetcode.ACW_LeetCode;

public class LC263 {
    public boolean isUgly(int n) {
        if (n < 1) return false;
        int[] p = {2, 3, 5};
        int i = 0;
        while (i < 3) {
            while (n % p[i] == 0) {
                n /= p[i];
            }
            i++;
        }
        return n == 1;
    }
}
