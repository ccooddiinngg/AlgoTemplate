package Leetcode.Offer;

public class O40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Heap heap = new Heap();
        for (int num : arr) {
            heap.add(num);
        }
        int[] res = new int[k];
        int idx = 0;
        while (idx < k) {
            res[idx++] = heap.poll();
        }
        return res;
    }

    class Heap {
        int size;
        int[] heap;

        public Heap() {
            heap = new int[10010];
            size = 0;
        }

        void up(int idx) {
            while (heap[(idx - 1) / 2] > heap[idx]) {
                swap(heap, idx, (idx - 1) / 2);
                idx = (idx - 1) / 2;
            }
        }

        void down(int idx) {
            while (idx * 2 + 1 < size) {
                int min = idx * 2 + 1;
                if (idx * 2 + 2 < size && heap[idx * 2 + 2] < heap[min]) {
                    min = idx * 2 + 2;
                }
                if (heap[idx] < heap[min]) break;
                swap(heap, idx, min);
                idx = min;
            }
        }

        boolean isEmpty() {
            return size == 0;
        }

        void add(int val) {
            heap[size++] = val;
            up(size - 1);
        }

        int poll() {
            if (isEmpty()) throw new NullPointerException();
            int t = heap[0];
            swap(heap, 0, size - 1);
            size--;
            down(0);
            return t;
        }

        void swap(int[] heap, int i, int j) {
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }
    }
}
