package ZuoChengyun.Middle.Day4;

import org.junit.jupiter.api.Test;

public class Machine {
    public static int run(int[] arr) {
        int m = arr.length;
        int rSum = 0;
        int lSum = 0;
        for (int i = 0; i < m; i++) {
            rSum += arr[i];
        }
        if (rSum % m != 0) return -1;

        int av = rSum / m;
        int[] left = new int[m];
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                left[i] = 0;
            } else {
                lSum += arr[i - 1];
                left[i] = lSum - i * av;
            }
            if (i == m - 1) {
                right[i] = 0;
            } else {
                rSum -= arr[i];
                right[i] = rSum - (m - 1 - i) * av;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(getMax(left[i], right[i]), max);
        }
        return max;
    }

    private static int getMax(int left, int right) {
        if (left <= 0 && right <= 0) {
            return Math.abs(left) + Math.abs(right);
        }
        return Math.max(Math.abs(left), Math.abs(right));
    }

    @Test
    void test() {
        int[] arr = {10, 50, 40, 20};
        System.out.println(run(arr));
    }
}
