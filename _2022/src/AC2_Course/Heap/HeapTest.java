package AC2_Course.Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapTest {
    Heap heap = new Heap(10);

    @Test
    void test() {
        heap.add("a", 3);
        heap.add("b", 2);
        heap.add("c", 1);
        heap.add("d", 1);
        heap.add("e", 5);
        heap.add("f", 4);
        System.out.println(Arrays.toString(heap.heap));
        System.out.println(heap.map);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(Arrays.toString(heap.heap));
        System.out.println(heap.map);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.map);
        Assertions.assertThrows(NullPointerException.class, () -> heap.pop());
    }


}