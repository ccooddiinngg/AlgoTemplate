package tag.Design;

class KthLargestElementInAStream {
    int k;
    Heap q;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.q = new Heap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        q.add(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }

    class Heap {
        int[] heap;
        int size;

        public Heap(int k) {
            this.heap = new int[k + 1];
            this.size = 0;
        }

        int size() {
            return this.size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int parent(int idx) {
            return (idx - 1) / 2;
        }

        int leftChild(int idx) {
            return idx * 2 + 1;
        }

        int rightChild(int idx) {
            return idx * 2 + 2;
        }

        void up(int idx) {
            while (heap[parent(idx)] > heap[idx]) {
                swap(heap, parent(idx), idx);
                idx = parent(idx);
            }
        }

        void down(int idx) {
            while (leftChild(idx) < size) {
                int min = leftChild(idx);
                if (rightChild(idx) < size && heap[rightChild(idx)] < heap[leftChild(idx)]) {
                    min = rightChild(idx);
                }
                if (heap[idx] <= heap[min]) break;
                swap(heap, idx, min);
                idx = min;
            }
        }

        void add(int val) {
            heap[size++] = val;
            up(size - 1);
        }

        int poll() {
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

        void swap(int[] heap, int i, int j) {
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
