package Leetcode.Coding_Interview_6.C03;

import java.util.Stack;

public class S05 {
    class SortedStack {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public SortedStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int val) {
            while (!s1.isEmpty() && s1.peek() < val) {
                s2.push(s1.pop());
            }
            s1.push(val);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public void pop() {
            if (!s1.isEmpty()) {
                s1.pop();
            }
        }

        public int peek() {
            return s1.isEmpty() ? -1 : s1.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }
}
