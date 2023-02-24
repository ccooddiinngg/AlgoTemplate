package Leetcode.Offer;

public class O59_2 {
    class MaxQueue {
        int[] q;
        int h;
        int e;

        int[] arr;
        int head;
        int end;

        public MaxQueue() {
            q = new int[10010];
            h = 0;
            e = 0;
            arr = new int[10010];
            head = 0;
            end = 0;
        }

        boolean isEmp() {
            return e - h <= 0;
        }

        boolean isEmpty() {
            return end - head <= 0;
        }

        public int max_value() {
            if (isEmpty()) return -1;
            return arr[q[h]];
        }

        public void push_back(int value) {
            arr[end] = value;
            while (!isEmp() && arr[q[e - 1]] < value) e--;
            q[e++] = end;
            end++;
        }

        public int pop_front() {
            if (isEmpty()) return -1;
            int res = arr[head];
            if (q[h] == head) h++;
            head++;
            return res;
        }
    }
}
