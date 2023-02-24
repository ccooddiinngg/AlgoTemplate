package Leetcode.Coding_Interview_6.C16;

public class S05 {
    public int trailingZeroes(int n) {
        long res = 0;
        long pow = 5;
        while (pow <= n) {
            res += n / pow;
            pow *= 5;
        }
        return (int) res;
    }

    /* count = n / 5 + n / 25 + n / 125 + ...
     * 最终分母可能过大溢出，上面的式子可以进行转换
     *
     * count = n / 5 + n / 5 / 5 + n / 5 / 5 / 5 + ...
     * 因此，我们这样进行循环
     *   n /= 5;
     *   count += n;
     */
    public int trailingZeroes1(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }

}
