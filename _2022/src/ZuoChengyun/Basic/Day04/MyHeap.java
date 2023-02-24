package ZuoChengyun.Basic.Day04;

import java.util.*;

class SomeT {
    int num;

    public SomeT(int num) {
        this.num = num;
    }
}

public class MyHeap<T> {
    private final List<T> heap = new ArrayList<>();
    private final Map<T, Integer> map = new HashMap<>();
    private int size = 0;
    private final int capacity;
    private final Comparator<T> comparator;

    public MyHeap(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(T val) {
        if (isFull()) {
            throw new RuntimeException("Full");
        }
        heap.add(val);
        map.put(val, size);
        heapInsert(size);
        size++;
    }

    private void heapInsert(int index) {
        while ((index - 1) / 2 >= 0 && comparator.compare(heap.get(index), heap.get((index - 1) / 2)) > 0) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        T val = heap.get(0);
        swap(heap, 0, size - 1);
        heap.remove(size - 1);
        size--;
        map.remove(val);
        heapify(0);
        return val;
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int max = left + 1 < size && comparator.compare(heap.get(left), heap.get(left + 1)) < 0 ?
                    left + 1 : left;
            max = comparator.compare(heap.get(index), heap.get(max)) > 0 ? index : max;
            if (max == index) {
                break;
            }
            swap(heap, index, max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private void swap(List<T> heap, int i, int j) {
        T vi = heap.get(i);
        T vj = heap.get(j);
        heap.set(i, vj);
        map.put(vj, i);
        heap.set(j, vi);
        map.put(vi, j);
    }

    public void resign(T val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            heapInsert(index);
            heapify(index);
        }
    }

    public static void main(String[] args) {
        Comparator<SomeT> comparator = (o1, o2) -> o1.num - o2.num;

        MyHeap<SomeT> myHeap = new MyHeap<>(10, comparator);

        SomeT t0 = new SomeT(2);
        SomeT t1 = new SomeT(1);
        SomeT t2 = new SomeT(5);
        SomeT t3 = new SomeT(3);
        SomeT t4 = new SomeT(4);
        SomeT t5 = new SomeT(0);
        SomeT t6 = new SomeT(6);
        SomeT t7 = new SomeT(7);
        myHeap.push(t0);
        myHeap.push(t1);
        myHeap.push(t2);
        myHeap.push(t3);
        myHeap.push(t4);
        myHeap.push(t5);
        myHeap.push(t6);
        myHeap.push(t7);

        t5.num = 1;

        myHeap.resign(t5);

        while (!myHeap.isEmpty()) {
            System.out.println(myHeap.poll().num);
        }
    }

}


