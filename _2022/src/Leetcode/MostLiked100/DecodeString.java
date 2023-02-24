package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }
            i++;
            StringBuilder str = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
                str.insert(0, stack.pop());
            }
            if (!stack.isEmpty()) {
                stack.pop();
            }
            StringBuilder digits = new StringBuilder();
            while (!stack.isEmpty() && isDigit(stack.peek())) {
                digits.insert(0, stack.pop());
            }
            int num = digits.isEmpty() ? 1 : Integer.parseInt(digits.toString());
            StringBuilder strs = new StringBuilder();
            for (int count = 0; count < num; count++) {
                strs.append(str);
            }
            stack.push(strs.toString());
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }


    public boolean isDigit(String s) {
        return "0123456789".contains(s);
    }

    @Test
    void test() {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}

