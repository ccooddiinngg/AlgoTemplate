package template;

import java.util.Arrays;

public class LIS {
    public static int lis(int[] arr) {
        int m = arr.length;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int len = indexOf(dp, arr[i]);
            dp[len] = arr[i];
        }
        return indexOf(dp, Integer.MAX_VALUE);
    }

    //find the index of the num greater or equal tar
    private static int indexOf(int[] dp, int tar) {
        int i = 0;
        int j = dp.length;
        while (i < j) {
            int mid = i + j >> 1;
            if (dp[mid] >= tar) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
