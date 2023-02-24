package Playground.Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapTest {
    Heap heap = new Heap(10);

    @Test
    void test() {
        heap.add(3);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(5);

        System.out.println(heap.peek());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.peek());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        Assertions.assertThrows(NullPointerException.class, () -> heap.pop());
    }
}