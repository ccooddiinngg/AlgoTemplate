package Leetcode.Offer;

import java.util.Stack;

public class O30 {
    class MinStack {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> sm = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (s.isEmpty()) {
                s.push(x);
                sm.push(x);
            } else {
                if (x < sm.peek()) {
                    sm.push(x);
                } else {
                    sm.push(sm.peek());
                }
                s.push(x);
            }
        }

        public void pop() {
            s.pop();
            sm.pop();
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return sm.peek();
        }
    }
}
