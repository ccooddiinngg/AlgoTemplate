package template;

public class BinarySearch {
    public static int findLessEqual(int[] arr, int tar) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (arr[mid] <= tar) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return arr[i] <= tar ? i : -1;
    }

    public static int findGreaterEqual(int[] arr, int tar) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (arr[mid] >= tar) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return arr[i] >= tar ? i : arr.length;
    }
}
