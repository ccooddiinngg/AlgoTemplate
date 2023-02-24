package Playground;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class P12 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(12);
        deque.add(1);
        deque.add(22);
        deque.add(121);

        System.out.println(deque.peek());
        System.out.println(deque.peekLast());
        System.out.println(deque);

    }
}
