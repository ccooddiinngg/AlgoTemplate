package Utils;

import java.util.Comparator;

public class Heap<T> {
    T[] heap;
    int cap;
    int size;

    Comparator<T> comparator;

    public Heap(int cap, Comparator<T> comparator) {
        this.cap = cap;
        heap = (T[]) new Object[cap];
        size = 0;
        this.comparator = comparator;
    }

    void up(int idx) {
        while (comparator.compare(heap[idx], heap[(idx - 1) / 2]) < 0) {
            swap(idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    void down(int idx) {
        while (idx * 2 + 1 < size) {
            int minIdx = comparator.compare(heap[idx], heap[idx * 2 + 1]) < 0 ? idx : idx * 2 + 1;
            if (idx * 2 + 2 < size && comparator.compare(heap[idx * 2 + 2], heap[minIdx]) < 0) {
                minIdx = idx * 2 + 2;
            }
            if (minIdx == idx) break;
            swap(idx, minIdx);
            idx = minIdx;
        }
    }

    public int size() {
        return size;
    }

    boolean isFull() {
        return size == cap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(T num) {
        if (isFull()) return;
        heap[size] = num;
        up(size);
        size++;
    }

    public T peek() {
        if (isEmpty()) throw new NullPointerException();
        return heap[0];
    }

    public T poll() {
        if (isEmpty()) throw new NullPointerException();
        T p = heap[0];
        swap(0, size - 1);
        size--;
        down(0);
        return p;
    }

    void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}