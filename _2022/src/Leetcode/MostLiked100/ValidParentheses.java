package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && (stack.peek() == '(' && c == ')' || stack.peek() == '[' && c == ']' || stack.peek() == '{' && c == '}')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }


    @Test
    void test() {
        String s = "([{}])";
        System.out.println(isValid(s));
    }
}
