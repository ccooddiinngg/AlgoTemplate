package Leetcode.Coding_Interview_6.C16;

public class S16a {
    public int[] subSort(int[] array) {
        int n = array.length;
        int l = -1;
        int r = -1;
        if (n < 2) {
            return new int[]{l, r};
        }
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < max) {
                r = i;
            } else {
                max = array[i];
            }
        }
        int min = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (array[i] > min) {
                l = i;
            } else {
                min = array[i];
            }
        }

        return new int[]{l, r};
    }
}
