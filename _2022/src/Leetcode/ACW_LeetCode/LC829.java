package Leetcode.ACW_LeetCode;

public class LC829 {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int k = 1;
        while (n - ((k - 1) * k / 2) >= 1) {
            if ((n - (k - 1) * k / 2) % k == 0) {
                count++;
            }
            k++;
        }
        return count;
    }
}
