package template;

public class PriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int leftChild(int idx) {
        return idx * 2 + 1;
    }

    private int rightChild(int idx) {
        return idx * 2 + 2;
    }

    private void up(int idx) {
        while (this.heap[idx] < this.heap[parent(idx)]) {
            swap(this.heap, parent(idx), idx);
            idx = parent(idx);
        }
    }

    private void down(int idx) {
        while (leftChild(idx) < this.size) {
            int minIdx = leftChild(idx);
            if (rightChild(idx) < this.size && this.heap[rightChild(idx)] < this.heap[minIdx]) {
                minIdx = rightChild(idx);
            }
            if (this.heap[idx] < this.heap[minIdx]) {
                break;
            }
            swap(this.heap, minIdx, idx);
            idx = minIdx;
        }
    }

    public void offer(int v) {
        if (isFull()) throw new NullPointerException();
        this.heap[size++] = v;
        up(size - 1);
    }

    public int peek() {
        if (isEmpty()) throw new NullPointerException();
        return this.heap[0];
    }

    public int poll() {
        if (isEmpty()) throw new NullPointerException();
        int res = this.heap[0];
        swap(this.heap, 0, size - 1);
        size--;
        down(0);
        return res;
    }

    private void swap(int[] heap, int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

}
