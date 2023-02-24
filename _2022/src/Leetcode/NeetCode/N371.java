package Leetcode.NeetCode;

public class N371 {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int xor = a ^ b;
        int carry = (a & b) << 1;
        return getSum(xor, carry);
    }
}
