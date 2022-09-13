import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    PriorityQueue q = new PriorityQueue(10);

    @Test
    void test() {
        assertTrue(q.isEmpty());
        assertFalse(q.isFull());
        assertEquals(0, q.size());

        q.offer(1);
        q.offer(3);
        q.offer(2);
        q.offer(4);
        assertEquals(1, q.peek());
        assertEquals(1, q.poll());
        assertEquals(2, q.poll());
        assertEquals(3, q.peek());
        assertEquals(3, q.poll());
        assertEquals(4, q.poll());
        assertEquals(0, q.size());
        assertThrows(NullPointerException.class, () -> q.peek());
        assertThrows(NullPointerException.class, () -> q.poll());

        for (int i = 0; i < 10; i++) {
            q.offer(12);
        }
        assertEquals(12, q.peek());
        assertThrows(NullPointerException.class, () -> q.offer(12));
    }

}