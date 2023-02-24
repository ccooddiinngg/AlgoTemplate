package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> min;
    public Stack<Integer> s;

    public MinStack() {
        this.min = new Stack<>();
        this.s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(val);
            min.push(val);
        } else {
            s.push(val);
            min.push(val < min.peek() ? val : min.peek());
        }

    }

    public Integer pop() {
        if (s.isEmpty()) return null;
        min.pop();
        return s.pop();
    }

    public Integer getMin() {
        if (min.isEmpty()) return null;
        return min.peek();
    }

    @Test
    void test() {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(1);
        minStack.push(3);
        minStack.push(2);

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
