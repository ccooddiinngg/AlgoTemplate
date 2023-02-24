package Leetcode.ACW_LeetCode;

import java.util.Stack;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                int last = stack.pop();
                right[last] = i;
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            }else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int last = stack.pop();
            right[last] = n;
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
