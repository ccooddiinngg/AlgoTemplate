package Leetcode.Coding_Interview_6.C16;

public class S07 {
    public int maximum(int a, int b) {
        long x = a;
        long y = b;
        int sign = (int) (1 + (x - y >> 63)); //取符号位 a < b ? 1:0
        return a * sign + b * (1 - sign);
    }
}
