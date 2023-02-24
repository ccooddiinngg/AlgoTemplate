package Leetcode.Coding_Interview_6.C16;

import java.util.HashSet;
import java.util.Set;

public class S21 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int v : array1) {
            sum1 += v;
        }
        Set<Integer> set = new HashSet<>();
        for (int v : array2) {
            set.add(v);
            sum2 += v;
        }

        int t = sum1 - sum2;
        if (t % 2 != 0) return new int[0];
        t /= 2;
        for (int i = 0; i < array1.length; i++) {
            if (set.contains(array1[i] - t)) return new int[]{array1[i], array1[i] - t};
        }
        return new int[0];
    }
}
