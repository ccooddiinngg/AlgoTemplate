package ZuoChengyun.Basic.Day03;

import ZuoChengyun.Basic.Utils.Utils;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] array, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int[] bound = partition(array, left, right);
        quickSort(array, left, bound[0]);
        quickSort(array, bound[1], right);
    }

    /**
     * @return [m, n] , a range of numbers equals array[right-1],
     * m: index of left bound , n: index of right bound
     */
    static int[] partition(int[] array, int left, int right) {
//        if (left == right - 1) {
//            return new int[]{left, right};
//        }
        int i = left;
        int m = left;
        int n = right;
        int seed = array[(int) (Math.random() * (right - left)) + left];

        while (i < n) {
            if (array[i] == seed) {
                i++;
            } else if (array[i] < seed) {
                swap(array, i, m);
                m++;
                i++;
            } else {
                swap(array, i, n - 1);
                n--;
            }
        }
        return new int[]{m, n};
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = Utils.createRandomIntArray(1000000);
//        System.out.println(Arrays.toString(partition(array, 0, array.length)));
        quickSort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}
