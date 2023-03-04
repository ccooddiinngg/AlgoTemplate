package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        String str = s.replace(" ", "");
        int m = str.length();
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);
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
                if (c == '(') {
                    s2.push('(');
                    if (i < m - 1 && str.charAt(i + 1) == '-') {
                        s1.push(0);
                    }
                } else if (c == ')') {
                    if (s2.peek() != '(') {
                        eval(s1, s2);
                    }
                    s2.pop();
                } else {
                    if (!s2.isEmpty() && s2.peek() != '(') {
                        eval(s1, s2);
                    }
                    s2.push(c);
                }

            }
        }
        eval(s1, s2);
        return s1.pop();
    }

    void eval(Stack<Integer> s1, Stack<Character> s2) {
        if (s2.isEmpty()) return;
        int b = s1.pop();
        int a = s1.pop();
        int c = 0;
        Character op = s2.pop();
        switch (op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            default -> {
            }
        }
        s1.push(c);
    }


    @Test
    void test() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = " 2-1 + 2";
        Assertions.assertEquals(23, calculate(s));
        Assertions.assertEquals(3, calculate(s1));
    }
}
