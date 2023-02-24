package ZuoChengyun.Middle.Day9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindLostNumber {
    // [1...N], lost one number
    public static int find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (num != arr[num - 1]) {
                int temp = arr[num - 1];
                arr[num - 1] = num;
                num = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(Arrays.toString(arr));
                return i + 1;
            }
        }
        return -1;
    }

    @Test
    void test() {
        int[] arr = {1, 3, 2, 5, 3};
        System.out.println(find(arr));
    }
}
