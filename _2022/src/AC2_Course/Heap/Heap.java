package AC2_Course.Heap;

import java.util.HashMap;
import java.util.Map;

public class Heap {

    static class Node {
        String id;
        int val;

        public Node(String id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public String toString() {
            return id + ": " + String.valueOf(val) + " ";
        }
    }

    Node[] heap;
    int size;
    Map<String, Integer> map;

    public Heap(int C) {
        heap = new Node[C];
        size = 0;
        map = new HashMap<>();
    }

    void heapify(int index) {
        while (index * 2 + 1 < size) {
            int min = index * 2 + 1;
            if (index * 2 + 2 < size) {
                min = heap[min].val < heap[index * 2 + 2].val ? min : index * 2 + 2;
            }
            if (heap[index].val <= heap[min].val) {
                break;
            }
            swap(index, min);
            index = min;
        }
    }

    void heapInsert(int index) {
        while ((index - 1) / 2 >= 0) {
            int min = (index - 1) / 2;
            if (heap[index].val >= heap[min].val) {
                break;
            }
            swap(index, min);
            index = min;
        }
    }

    void swap(int i, int j) {
        Node t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
        map.put(heap[i].id, i);
        map.put(heap[j].id, j);
    }

    public void add(String id, int val) {
        Node node = new Node(id, val);
        heap[size++] = node;
        map.put(id, size - 1);
        heapInsert(size - 1);
    }

    public String pop() {
        if (!isEmpty()) {
            Node min = heap[0];
            swap(0, size - 1);
            size--;
            map.put(min.id, -1);
            heapify(0);
            return min.id;
        }
        throw new NullPointerException();
    }


    public Node peek() {
        if (!isEmpty()) {
            return heap[0];
        }
        throw new NullPointerException();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
