package Leetcode.ACW_LeetCode;

import java.util.Stack;

public class LC456a {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[n - 1]);
        int max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < max) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = Math.max(max, stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
