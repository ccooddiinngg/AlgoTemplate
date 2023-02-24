package Leetcode.Coding_Interview_6.C17;

import java.util.PriorityQueue;
import java.util.Queue;

public class S20a {
    class MedianFinder {
        Queue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> right = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());

            if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
        }

        public double findMedian() {
            if (right.size() == 0) {
                throw new NullPointerException();
            }
            if (left.size() < right.size()) {
                return right.peek();
            } else {
                return (left.peek() + right.peek()) / 2.0;
            }
        }
    }
}
