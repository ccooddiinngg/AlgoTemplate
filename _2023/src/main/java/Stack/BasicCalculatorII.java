package Stack;

import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Map<Character, Integer> map = Map.of('+', 0, '-', 0, '*', 1, '/', 1);
        String str = s.replace(" ", "");
        int m = str.length();
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int pre = 0;
        for (int i = 0; i < m; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i == m - 1 || (i < m - 1 && !Character.isDigit(str.charAt(i + 1)))) {
                    s1.push(pre);
                    pre = 0;
                }
            } else {
                //! while not if
                while (!s2.isEmpty() && map.get(c) <= map.get(s2.peek())) {
                    eval(s1, s2);
                }
                s2.push(c);
            }
        }
        while (!s2.isEmpty()) {
            eval(s1, s2);
        }
        return s1.pop();
    }

    public void eval(Stack<Integer> s1, Stack<Character> s2) {
        int b = s1.pop();
        int a = s1.pop();
        int c = 0;
        char op = s2.pop();
        switch (op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            case '*' -> c = a * b;
            case '/' -> c = a / b;
            default -> {
            }
        }
        s1.push(c);
    }

}
