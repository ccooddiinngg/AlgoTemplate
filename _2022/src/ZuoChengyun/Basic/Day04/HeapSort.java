package ZuoChengyun.Basic.Day04;

import ZuoChengyun.Basic.Utils.Utils;

import java.util.Arrays;

public class HeapSort {
    static void sort(int[] array) {
        MaxHeap heap = new MaxHeap(array.length);
//        for (int i = 0; i < array.length; i++) {
//            heap.push(array[i]);
//        }
        for (int i = 0; i < array.length; i++) {
            heap.heap[i] = array[i];
            heap.size++;
        }
        for (int j = array.length - 1; j >= 0; j--) {
            heap.heapify(j);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heap.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = Utils.createRandomIntArray(10);
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
