package tag.Design;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    class MedianFinder {

        Queue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q2 = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (q1.isEmpty()) {
                q1.offer(num);
                return;
            }
            if (num > q1.peek()) {
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
            if (q1.isEmpty()) throw new NullPointerException();
            if ((q1.size() + q2.size()) % 2 == 0) {
                return (q1.peek() + q2.peek()) / 2.0;
            }
            return q1.peek() / 1.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}


