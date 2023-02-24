package ZuoChengyun.Basic.Day04;

public class MaxHeap {
    int[] heap;
    int capacity;
    int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size >= capacity;
    }

    void push(int val) {
        if (isFull()) {
            return;
        }
        heap[size] = val;
        heapInsert(size);
        size++;
    }

    void heapInsert(int index) {
        while (heap[(index - 1) / 2] < heap[index]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }
        int val = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return val;

    }

    void heapify() {
        int index = 0;
        int left = 2 * index + 1;
        while (left < size) {
            int max = left + 1 < size && heap[left + 1] > heap[left] ? left + 1 : left;
            max = heap[max] > heap[index] ? max : index;
            if (max == index) break;
            swap(heap, index, max);
            index = max;
            left = 2 * index + 1;
        }
    }

    void heapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max;
        if (left < size && heap[left] > heap[index]) max = left;
        else max = index;
        if (right < size && heap[right] > heap[max]) max = right;
        if (max != index) {
            swap(heap, index, max);
            heapify(max);
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeap.push(3);
        maxHeap.push(2);
        maxHeap.push(4);
        maxHeap.push(1);
        maxHeap.push(5);
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        maxHeap.push(6);
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
        maxHeap.push(5);
        maxHeap.push(4);
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());

    }
}
