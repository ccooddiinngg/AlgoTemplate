package Leetcode.ACW_LeetCode;

public class LC42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += Math.max(Math.min(left[i] , right[i]) - height[i], 0);
        }
        return sum;
    }
}
