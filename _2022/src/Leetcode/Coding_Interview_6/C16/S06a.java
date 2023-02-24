package Leetcode.Coding_Interview_6.C16;

import java.util.Arrays;

public class S06a {
    public int smallestDifference(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            return smallestDifference(b, a);
        }
        Arrays.sort(b);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long t = find(a[i], b, n);
            min = Math.min(min, t);
        }
        return (int) min;
    }

    long find(int num, int[] b, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (b[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        int right = i;
        i = 0;
        j = n - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (b[mid] <= num) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        int left = i;
        return Math.min(Math.abs((long) num - (long) b[left]), Math.abs((long) num - (long) b[right]));
    }
}

