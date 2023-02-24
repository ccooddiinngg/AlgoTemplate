package Leetcode.ACW_LeetCode;

import java.util.Stack;

public class LC224 {
    Stack<Character> op = new Stack<>();
    Stack<Integer> dig = new Stack<>();

    public int calculate(String s) {
        String str = s.replace(" ", "");
        dig.push(0);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == str.length() - 1 || !Character.isDigit(str.charAt(i + 1))) {
                    dig.push(num);
                    num = 0;
                }
            }
            if (c == '(') {
                op.push(c);
                if (str.charAt(i + 1) == '-') {
                    dig.push(0);
                }
            }
            if (c == ')') {
                while (op.peek() != '(') {
                    eval();
                }
                op.pop();
            }
            if (c == '+' || c == '-') {
                while (!op.isEmpty() && (op.peek() == '+' || op.peek() == '-')) {
                    eval();
                }
                op.push(c);
            }
        }
        if (!op.isEmpty()) eval();
        return dig.pop();
    }

    void eval() {
        int c = 0;
        int b = dig.pop();
        int a = dig.pop();
        char o = op.pop();
        if (o == '+') {
            c = a + b;
        }
        if (o == '-') {
            c = a - b;
        }
        dig.push(c);
    }
}
