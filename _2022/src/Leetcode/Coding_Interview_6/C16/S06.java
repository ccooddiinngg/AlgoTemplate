package Leetcode.Coding_Interview_6.C16;

import java.util.Arrays;

public class S06 {
    public int smallestDifference(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        long min = Long.MAX_VALUE;
        while (i < m && j < n) {
            if (a[i] == b[j]) return 0;
            min = Math.min(min, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return (int) min;
    }
}
