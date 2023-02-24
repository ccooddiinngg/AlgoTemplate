package Leetcode.Coding_Interview_6.C17;

import java.util.PriorityQueue;
import java.util.Queue;

public class S20 {
    class MedianFinder {
        Queue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> right = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.isEmpty() && right.isEmpty()) {
                left.add(num);
            } else if (left.isEmpty()) {
                if (right.peek() < num) {
                    right.add(num);
                } else {
                    left.add(num);
                }
            } else if (right.isEmpty()) {
                if (left.peek() > num) {
                    left.add(num);
                } else {
                    right.add(num);
                }
            } else {
                if (left.peek() > num) {
                    left.add(num);
                } else {
                    right.add(num);
                }
            }
            if (left.size() > right.size()) {
                right.add(left.poll());
            }
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
