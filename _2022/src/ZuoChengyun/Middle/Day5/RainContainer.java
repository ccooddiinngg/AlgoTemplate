package ZuoChengyun.Middle.Day5;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RainContainer {

    //position i = Max(Min(leftMax, rightMax) - num[i], 0)
    public static int find2Pointer(int[] arr) {
        int left = arr[0];
        int right = arr[arr.length - 1];
        int i = 1;
        int j = arr.length - 2;
        int max = 0;
        while (i <= j) {
            if (left <= right) {
                max += Math.max(left - arr[i], 0);
                left = Math.max(left, arr[i]);
                i++;
            } else {
                max += Math.max(right - arr[j], 0);
                right = Math.max(right, arr[j]);
                j--;
            }
        }
        return max;
    }

    @Test
    void test() {
        int[] arr = {3, 2, 1, 4, 5};

        System.out.println(find2Pointer(arr));
    }
}
