package ZuoChengyun.Basic.Day02;

import java.util.EmptyStackException;
import java.util.Stack;

public class AQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int val) {
        s1.push(val);
    }

    int pull() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new EmptyStackException();
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        AQueue aQueue = new AQueue();
        aQueue.push(3);
        aQueue.push(4);
        aQueue.push(5);

        System.out.println(aQueue.pull());
        aQueue.push(8);
        aQueue.push(9);
        aQueue.push(10);
        System.out.println(aQueue.pull());
        System.out.println(aQueue.pull());
        System.out.println(aQueue.pull());
        aQueue.push(11);
        System.out.println(aQueue.pull());
        System.out.println(aQueue.pull());
        System.out.println(aQueue.pull());

    }
}
