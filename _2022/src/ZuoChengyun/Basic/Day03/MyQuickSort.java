package ZuoChengyun.Basic.Day03;

import ZuoChengyun.Basic.Utils.Utils;

import java.util.Arrays;

public class MyQuickSort {
    static void quickSort(int[] array, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int seed = array[right - 1];
        int i = left;
        int j = right;
        int pointer = left;
        while (pointer < j) {
            if (array[pointer] == seed) {
                pointer++;
            } else if (array[pointer] < seed) {
                swap(array, pointer++, i++);
            } else {
                swap(array, pointer, j - 1);
                j--;
            }
        }
        quickSort(array, left, i);
        quickSort(array, j, right);
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
//        int[] array = {3, 1, 5, 4, 7, 1, 8, 9, 1};
        int[] array = Utils.createRandomIntArray(1000000);
        quickSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }

}
