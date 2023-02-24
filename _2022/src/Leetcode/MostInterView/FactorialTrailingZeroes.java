package Leetcode.MostInterView;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        //! 25 = 5 * 5 , 125 = 5 * 5 * 5 so on
        return n / 5 + trailingZeroes(n / 5);
    }
}
