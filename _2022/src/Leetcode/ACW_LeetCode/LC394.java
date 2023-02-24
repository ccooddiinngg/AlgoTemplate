package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LC394 {
    // 遇到'[' 数字和字母入栈,遇到']'数字字母出栈拼接
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                s1.push(num);
                s2.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
            } else {
                int digit = s1.pop();
                StringBuilder t = new StringBuilder();
                for (int j = 0; j < digit; j++) {
                    t.append(sb);
                }
                t.insert(0, s2.pop());
                sb = t;
            }
        }
        while (!s2.isEmpty()) {
            sb.insert(0, s2.pop());
        }
        return sb.toString();
    }

    @Test
    void test() {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

}
