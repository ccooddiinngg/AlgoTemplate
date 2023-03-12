package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                s1.push(i);
            } else if (c == ')') {
                if (!s1.isEmpty()) {
                    s1.pop();
                } else {
                    if (s2.isEmpty()) {
                        return false;
                    }
                    s2.pop();
                }
            } else {
                s2.push(i);
            }
        }
        while (!s1.isEmpty()) {
            if (s2.isEmpty() || s2.peek() < s1.peek()) {
                return false;
            }
            s1.pop();
            s2.pop();
        }
        return true;
    }
}
