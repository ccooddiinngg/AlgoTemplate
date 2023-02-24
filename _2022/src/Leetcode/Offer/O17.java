package Leetcode.Offer;

public class O17 {
    public int[] printNumbers(int n) {
        int m = (int) Math.pow(10, n) - 1;
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
