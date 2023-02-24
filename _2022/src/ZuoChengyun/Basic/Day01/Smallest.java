package ZuoChengyun.Basic.Day01;

import org.junit.jupiter.api.Test;

public class Smallest {
    //
    int find(int[] array) throws Exception {
        int l = array.length;

        if (l <= 2) {
            int min = Integer.MAX_VALUE;
            for (int j : array) {
                min = Math.min(j, min);
            }
            return min;
        }

        if (array[0] < array[1]) return 0;
        if (array[l - 1] < array[l - 2]) return l - 1;

        int left = 0;
        int right = l;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < array[mid + 1] && array[mid] < array[mid - 1]) {
                return mid;
            }
            if (array[mid] > array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        throw new Exception();
    }

    @Test
    void test1() throws Exception {
        int[] array = {5, 3, 6, 7, 5, 2, 3};
        int index = find(array);
        System.out.println(index);
    }
}
