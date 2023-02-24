package Leetcode.Coding_Interview_6.C17;

public class S21 {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        max = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}
