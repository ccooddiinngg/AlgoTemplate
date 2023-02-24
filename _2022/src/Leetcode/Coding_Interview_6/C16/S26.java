package Leetcode.Coding_Interview_6.C16;

import java.util.Map;
import java.util.Stack;

public class S26 {
    public int calculate(String s) {
        Map<Character, Integer> map = Map.of('+', 1, '-', 1, '*', 2, '/', 2);

        Stack<Character> op = new Stack<>();
        Stack<Integer> dig = new Stack<>();
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (map.containsKey(c)) {
                while (!op.isEmpty() && map.get(op.peek()) >= map.get(c)) {
                    int b = dig.pop();
                    int a = dig.pop();
                    char oper = op.pop();
                    int res = cal(a, b, oper);
                    dig.push(res);
                }
                op.push(c);
            } else if (Character.isDigit(c)) {
                pre = pre * 10 + Integer.parseInt(String.valueOf(c));
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    dig.push(pre);
                    pre = 0;
                }
            }
        }
        while (!op.isEmpty()) {
            int b = dig.pop();
            int a = dig.pop();
            char oper = op.pop();
            int res = cal(a, b, oper);
            dig.push(res);
        }
        return dig.pop();
    }

    int cal(int a, int b, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b != 0) {
                    res = a / b;
                }
                break;
            default:
                break;
        }
        return res;
    }
}
