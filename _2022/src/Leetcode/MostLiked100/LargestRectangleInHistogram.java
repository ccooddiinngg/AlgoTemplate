package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int m = heights.length;
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            int p = i - 1;
            while (p >= 0 && heights[i] <= heights[p]) {
                p = left[p];
            }
            left[i] = p;
        }

        int[] right = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            int n = i + 1;
            while (n <= m - 1 && heights[i] <= heights[n]) {
                n = right[n];
            }
            right[i] = n;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - 1 - left[i]) * heights[i]);
        }
        return max;
    }

    @Test
    void test() {
        int[] heights = {2, 4};
        System.out.println(largestRectangleArea(heights));
    }
}
