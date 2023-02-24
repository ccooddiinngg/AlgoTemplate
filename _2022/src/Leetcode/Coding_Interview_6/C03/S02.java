package Leetcode.Coding_Interview_6.C03;

import java.util.Stack;

public class S02 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                if (x < min.peek()) {
                    min.push(x);
                } else {
                    min.push(min.peek());
                }
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                min.pop();
            } else {
                throw new NullPointerException();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            } else {
                throw new NullPointerException();
            }
        }

        public int getMin() {
            if (!stack.isEmpty()) {
                return min.peek();
            } else {
                throw new NullPointerException();
            }
        }
    }
}
