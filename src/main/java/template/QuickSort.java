package template;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int idx = partition(arr, l, r);
        quickSort(arr, l, idx);
        quickSort(arr, idx + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int mid = arr[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (arr[++i] < mid) ;
            while (arr[--j] > mid) ;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
