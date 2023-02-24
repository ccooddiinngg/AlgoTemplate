package ZuoChengyun.Basic.Day03;

import ZuoChengyun.Basic.Utils.Utils;

import java.util.Arrays;

public class MergeSort {
    static void sort(int[] unsorted, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(unsorted, left, mid);
        sort(unsorted, mid, right);
        merge(unsorted, left, mid, right);
    }

    static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int[] temp = new int[right - left];
        int k = 0;
        while (i < mid && j < right) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < right) {
            temp[k++] = array[j++];
        }
        int m = left;
        int n = 0;
        while (m < right) {
            array[m++] = temp[n++];
        }
    }

    static void sortIteration(int[] unsorted) {
        int size = 1;
        while (size < unsorted.length) {
            int left = 0;
            while (left < unsorted.length) {
                int mid = left + size;
                if (mid >= unsorted.length) {
                    break;
                }
                int right = Math.min(mid + size, unsorted.length);
                merge(unsorted, left, mid, right);
                left = right;
            }
            //prevent overflow
            if (size > unsorted.length / 2) {
                break;
            }
            size *= 2;
        }
    }

    public static void main(String[] args) {
//        int[] unsorted = {3, 2, 4, 1, 5};
        int[] unsorted = Utils.createRandomIntArray(5);

        sort(unsorted, 0, unsorted.length);
//        sortIteration(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }
}
