package template;

public class Heap {
    int[] heap;
    int size;
    int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void up(int idx) {
        while (heap[idx] < heap[(idx - 1) / 2]) {
            swap(idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    private void down(int idx) {
        while (idx * 2 + 1 < size) {
            int minIdx = idx * 2 + 1;
            if (idx * 2 + 2 < size && heap[idx * 2 + 2] < heap[minIdx]) {
                minIdx = idx * 2 + 2;
            }
            if (heap[idx] < heap[minIdx]) {
                break;
            }
            swap(idx, minIdx);
            idx = minIdx;
        }
    }

    public void offer(int v) {
        if (isFull())
            throw new NullPointerException();
        heap[size++] = v;
        up(size - 1);
    }

    public int peek() {
        if (isEmpty())
            throw new NullPointerException();
        return heap[0];
    }

    public int poll() {
        if (isEmpty())
            throw new NullPointerException();
        int ret = heap[0];
        heap[0] = heap[--size];
        down(0);
        return ret;
    }

    public void remove(int v) {
        int idx = index(v);
        if (idx == -1)
            throw new NullPointerException();
        heap[idx] = heap[--size];
        down(idx);
    }

    //heap 中的数不能2分查找 [1, 3, 2]
    private int index(int v) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == v) return i;
        }
        return -1;
    }
}
