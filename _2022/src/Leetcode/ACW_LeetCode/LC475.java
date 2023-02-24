package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int a = findBigerThan(heaters, houses[i]);
            int b = findLessThan(heaters, houses[i]);
            int min = Integer.MAX_VALUE;
            if (a != Integer.MAX_VALUE) {
                min = Math.min(min, Math.abs(a - houses[i]));
            }
            if (b != Integer.MAX_VALUE) {
                min = Math.min(min, Math.abs(b - houses[i]));
            }
            max = Math.max(max, min);
        }
        return max;
    }

    int findBigerThan(int[] h, int num) {
        int i = 0;
        int j = h.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (h[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return h[i] >= num ? h[i] : Integer.MAX_VALUE;
    }

    int findLessThan(int[] h, int num) {
        int i = 0;
        int j = h.length - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (h[mid] <= num) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return h[i] <= num ? h[i] : Integer.MAX_VALUE;
    }
}
