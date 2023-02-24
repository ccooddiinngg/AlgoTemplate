package Leetcode.Offer;

import java.util.Stack;

public class O09 {
    static class CQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public CQueue() {

        }

        void trans(Stack<Integer> from, Stack<Integer> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                trans(s1, s2);
            }
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                return -1;
            }
        }
    }
}
