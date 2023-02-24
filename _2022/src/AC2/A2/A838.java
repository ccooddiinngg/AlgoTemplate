package AC2.A2;

import java.util.Scanner;

public class A838 {
    static int[] heap = new int[100010];
    static int size = 0;

    static void up(int index) {
        while (heap[index] < heap[(index - 1) / 2]) {
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

    static void swap(int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            System.out.print(poll() + " ");
        }
    }
}
