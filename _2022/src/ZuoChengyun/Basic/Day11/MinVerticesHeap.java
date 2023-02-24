package ZuoChengyun.Basic.Day11;

import java.util.HashMap;
import java.util.Map;

public class MinVerticesHeap {

    public Vertex[] heap;
    //if index == -1, means it was in heap
    public Map<Vertex, Integer> indexMap;
    //from origin vertex
    public Map<Vertex, Integer> weightMap;
    public int size;

    public MinVerticesHeap(int capacity) {
        heap = new Vertex[capacity];
        indexMap = new HashMap<>();
        weightMap = new HashMap<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= heap.length;
    }

    public boolean entered(Vertex v) {
        return indexMap.containsKey(v);
    }

    public boolean isPresent(Vertex v) {
        return indexMap.containsKey(v) && indexMap.get(v) != -1;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }

    public void addUpdateIgnore(Vertex v, int w) {
        if (isFull()) return;
        if (isPresent(v)) {
            weightMap.put(v, Math.min(w, weightMap.get(v)));
            insertHeapify(indexMap.get(v));
        }
        if (!entered(v)) {
            heap[size] = v;
            indexMap.put(v, size);
            weightMap.put(v, w);
            insertHeapify(size);
            size++;
        }
    }

    public Vertex pop() {
        if (isEmpty()) throw new RuntimeException("Heap is empty.");
        Vertex min = heap[0];
        swap(0, size - 1);
        indexMap.put(heap[size - 1], -1);
//        weightMap.remove(heap[size - 1]);
        size--;
        heapify(0);
        return min;
    }

    private void swap(int i, int j) {
        Vertex temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        indexMap.put(heap[i], i);
        indexMap.put(heap[j], j);
    }

    private void heapify(int i) {
        int leftIndex, rightIndex;
        while (i * 2 + 1 < size) {
            leftIndex = i * 2 + 1;
            rightIndex = i * 2 + 2;
            int minIndex = rightIndex < size && weightMap.get(heap[rightIndex]) < weightMap.get(heap[leftIndex]) ? rightIndex : leftIndex;
            minIndex = weightMap.get(heap[i]) < weightMap.get(heap[minIndex]) ? i : minIndex;
            if (minIndex == i) {
                break;
            }
            swap(i, minIndex);
            i = minIndex;
        }
    }

    private void insertHeapify(int i) {
        while (weightMap.get(heap[i]) < weightMap.get(heap[(i - 1) / 2])) {
            swap((i - 1) / 2, i);
            i = (i - 1) / 2;

        }
    }

}
