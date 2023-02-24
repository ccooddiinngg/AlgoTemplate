package Leetcode.ACW_LeetCode;

import java.util.Stack;

public class LC402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while (idx < num.length() && k > 0) {
            int n = Integer.parseInt(String.valueOf(num.charAt(idx)));
            //delete big num
            while (k > 0 && !stack.isEmpty() && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num.substring(idx));
        //delete big num if k > 0
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        //remove first 0
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) return "0";

        return sb.toString();
    }
}
