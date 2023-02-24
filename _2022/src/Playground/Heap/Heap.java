package Playground.Heap;

public class Heap {
    int[] heap;
    int size;
    int cap;

    public Heap(int cap) {
        this.cap = cap;
        this.heap = new int[cap];
        this.size = 0;
    }

    void up(int idx) {
        while (heap[idx] < heap[(idx - 1) / 2]) {
            swap(heap, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
    }

    void down(int idx) {
        while (idx * 2 + 1 < size) {
            int min = idx * 2 + 1;
            if (idx * 2 + 2 < size && heap[idx * 2 + 2] < heap[idx * 2 + 1]) {
                min = idx * 2 + 2;
            }
            if (heap[min] < heap[idx]) {
                swap(heap, min, idx);
                idx = min;
            } else {
                break;
            }
        }
    }

    void add(int x) {
        if (isFull()) throw new IndexOutOfBoundsException();
        heap[size] = x;
        up(size);
        size++;
    }

    int pop() {
        if (isEmpty()) throw new NullPointerException();
        int t = heap[0];
        swap(heap, 0, size - 1);
        size--;
        down(0);
        return t;
    }

    int peek() {
        if (isEmpty()) throw new NullPointerException();
        return heap[0];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == cap;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
