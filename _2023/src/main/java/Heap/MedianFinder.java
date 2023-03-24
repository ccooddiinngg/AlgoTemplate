package Heap;

import Utils.Heap;
import org.junit.jupiter.api.Test;

public class MedianFinder {

    Heap<Integer> q1 = new Heap<Integer>(100000, (a, b) -> b - a);
    Heap<Integer> q2 = new Heap<Integer>(100000, (a, b) -> a - b);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (!q2.isEmpty() && num >= q2.peek()) {
            q2.offer(num);
            if (q2.size() > q1.size()) {
                q1.offer(q2.poll());
            }
        } else {
            q1.offer(num);
            if (q1.size() > q2.size() + 1) {
                q2.offer(q1.poll());
            }
        }
    }

    public double findMedian() {
        return q1.size() == q2.size() ? (q1.peek() + q2.peek()) / 2.0 : q1.peek();
    }

    @Test
    void test() {

    }
}

