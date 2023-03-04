package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if ((state >> idx & 1) == 0) {
                state |= 1 << idx;
                while (!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] > 0) {
                    int pre = stack.pop() - 'a';
                    state -= (1 << pre);
                }
                stack.push(s.charAt(i));
            }
            //后面还有几个能选的
            count[idx]--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }


    @Test
    void test() {
        String s = "edebbed";
        Assertions.assertEquals("bed", removeDuplicateLetters(s));
    }
}

