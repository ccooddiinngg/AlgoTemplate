package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class AQueueStack {
    public Queue<Integer> q1 = new LinkedList<>();
    public Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        if (q1.isEmpty() && q2.isEmpty()) {
            q1.add(val);
        } else if (q1.isEmpty()) {
            q2.add(val);
        } else {
            q1.add(val);
        }

    }

    public Integer pop() {
        if (q1.isEmpty() && q2.isEmpty()) return null;
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.add(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
            return q1.poll();
        }
    }

    public Integer peek() {
        if (q1.isEmpty() && q2.isEmpty()) return null;
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.add(q2.poll());
            }
            return q2.peek();
        } else {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
            return q1.peek();
        }
    }

    @Test
    void test() {
        AQueueStack aQueueStack = new AQueueStack();
        aQueueStack.push(3);
        aQueueStack.push(5);
        aQueueStack.push(1);
        aQueueStack.push(4);

        System.out.println(aQueueStack.peek());
        System.out.println(aQueueStack.pop());
        System.out.println(aQueueStack.pop());
        System.out.println(aQueueStack.pop());
        System.out.println(aQueueStack.pop());
    }
}
