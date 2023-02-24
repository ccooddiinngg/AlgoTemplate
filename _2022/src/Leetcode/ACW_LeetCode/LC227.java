package Leetcode.ACW_LeetCode;

import java.util.Map;
import java.util.Stack;

public class LC227 {
    Map<Character, Integer> map = Map.of('+', 1, '-', 1, '*', 2, '/', 2);
    Stack<Character> op = new Stack<>();
    Stack<Integer> nums = new Stack<>();

    public int calculate(String s) {
        String str = s.replace(" ", "");
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                while (!op.isEmpty() && map.get(op.peek()) >= map.get(c)) {
                    eval();
                }
                op.push(c);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == str.length() - 1 || !Character.isDigit(str.charAt(i + 1))) {
                    nums.push(num);
                    num = 0;
                }
            }
        }
        while (!op.isEmpty()) eval();
        return nums.pop();
    }

    void eval() {
        int b = nums.pop();
        int a = nums.pop();
        int c = 0;
        char o = op.pop();
        switch (o) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            case '*':
                c = a * b;
                break;
            case '/':
                c = a / b;
                break;
            default:
                break;
        }
        nums.push(c);
    }
}
