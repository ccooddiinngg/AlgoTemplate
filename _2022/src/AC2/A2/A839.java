package AC2.A2;

import java.util.Scanner;

public class A839 {
    static int[] heap = new int[100010];
    static int size = 0;
    static int[] heapPos = new int[100010];
    static int[] kPos = new int[100010];
    static int k = 1;

    static void up(int index) {
        while ((index - 1) / 2 >= 0 && heap[index] < heap[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    static void down(int index) {
        while (index * 2 + 1 < size) {
            int min = index * 2 + 1;
            if (index * 2 + 2 < size && heap[index * 2 + 2] < heap[min]) {
                min = index * 2 + 2;
            }
            if (heap[index] <= heap[min]) break;
            swap(index, min);
            index = min;
        }
    }

    static boolean isEmpty() {
        return size == 0;
    }

    static void add(int x) {
        heap[size] = x;
        heapPos[size] = k;
        kPos[k] = size;
        k++;
        up(size);
        size++;
    }

    static int poll() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        int m = heap[0];
        swap(0, size - 1);
        size--;
        down(0);
        return m;
    }

    static int peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return heap[0];
    }

    static void delete(int k) {
        int index = kPos[k];
        swap(index, size - 1);
        size--;
        up(index);
        down(index);
    }

    static void update(int k, int x) {
        int index = kPos[k];
        heap[index] = x;
        up(index);
        down(index);
    }

    static void swap(int i, int j) {
        swap(heap, i, j);
        swap(heapPos, i, j);
//        swap(kPos, heapPos[i], heapPos[j]);
        kPos[heapPos[i]] = i;
        kPos[heapPos[j]] = j;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "I":
                    add(Integer.parseInt(s[1]));
                    break;
                case "PM":
                    System.out.println(peek());
                    break;
                case "DM":
                    poll();
                    break;
                case "D":
                    delete(Integer.parseInt(s[1]));
                    break;
                case "C":
                    update(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    break;
                default:
                    break;
            }
        }
    }
}
