package ZuoChengyun.Basic.Day03;

import ZuoChengyun.Basic.Utils.Utils;

public class TestSorting {

    public static void main(String[] args) {
        int[] arr1 = Utils.createRandomIntArray(10000000);
        int[] arr2 = Utils.createRandomIntArray(10000000);

        Long start1 = System.currentTimeMillis();
        MergeSort.sort(arr1, 0, arr1.length);
        Long start2 = System.currentTimeMillis();

        System.out.println(start2 - start1);

        Long start3 = System.currentTimeMillis();
        QuickSort.quickSort(arr2, 0, arr1.length);
        Long start4 = System.currentTimeMillis();

        System.out.println(start4 - start3);
    }
}
