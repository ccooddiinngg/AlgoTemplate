package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class AStackQueue {
    public Stack<Integer> s1 = new Stack<>();
    public Stack<Integer> s2 = new Stack<>();

    public void push(int val) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(val);
    }

    public Integer poll() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public Integer peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    @Test
    void test() {
        AStackQueue aStackQueue = new AStackQueue();
        aStackQueue.push(3);
        aStackQueue.push(1);
        aStackQueue.push(5);
        aStackQueue.push(2);

        System.out.println(aStackQueue.poll());
        System.out.println(aStackQueue.poll());
        System.out.println(aStackQueue.peek());
        System.out.println(aStackQueue.poll());
        System.out.println(aStackQueue.poll());
    }
}
