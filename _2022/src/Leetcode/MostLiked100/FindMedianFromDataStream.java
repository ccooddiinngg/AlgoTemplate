package Leetcode.MostLiked100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindMedianFromDataStream {
    class MyHeap {
        ArrayList<Integer> heap = new ArrayList<>();
        Comparator<Integer> com;

        public MyHeap(Comparator<Integer> com) {
            this.com = com;
        }

        public int getSize() {
            return heap.size();
        }

        public Integer getTop() {
            return heap.get(0);
        }

        public Integer poll() {
            Integer val = heap.get(0);
            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            heapify(0);
            return val;
        }

        public void insert(int num) {
            heap.add(num);
            int index = heap.size() - 1;
            while ((index - 1) / 2 >= 0 && com.compare(heap.get(index), heap.get((index - 1) / 2)) > 0) {
                Collections.swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index) {
            while (index * 2 + 1 < heap.size()) {
                int target = index * 2 + 1;
                if (index * 2 + 2 < heap.size() && com.compare(heap.get(index * 2 + 2), heap.get(target)) > 0) {
                    target = index * 2 + 2;
                }
                if (com.compare(heap.get(index), heap.get(target)) > 0) {
                    target = index;
                }
                if (target == index) {
                    break;
                }
                Collections.swap(heap, index, target);
                index = target;
            }
        }

    }

    boolean even = true;
    MyHeap left;
    MyHeap right;

    public FindMedianFromDataStream() {
        left = new MyHeap((o1, o2) -> o1 - o2);
        right = new MyHeap((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (even) {
            left.insert(num);
            right.insert(left.poll());
        } else {
            right.insert(num);
            left.insert(right.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if ((left.getSize() + right.getSize()) % 2 == 0) {
            return (left.getTop() + right.getTop()) / 2.0;
        }
        return right.getTop();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(1);
        f.addNum(2);
        f.addNum(3);
        f.addNum(4);
        System.out.println(f.findMedian());
    }
}
