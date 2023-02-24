package Leetcode.Coding_Interview_6.C16;

public class S16 {
    public int[] subSort(int[] array) {
        int n = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 1 && array[i] < array[i - 1]) {
                min = Math.min(min, array[i]);
            }
            if (i < n - 1 && array[i] > array[i + 1]) {
                max = Math.max(max, array[i]);
            }
        }
        int l = -1;
        int r = -1;

        for (int i = 0; i < n; i++) {
            if (array[i] > min) {
                l = i;
                break;
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            if (array[j] < max) {
                r = j;
                break;
            }
        }
        return new int[]{l, r};
    }
}
