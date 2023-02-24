package ZuoChengyun.Basic.Day01;

import org.junit.jupiter.api.Test;

public class BinarySearch {

    //search ordered array
    boolean exist(int[] array, int num) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == num) return true;
            if (array[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    //find position where item >= num
    int find(int[] array, int num) {
        int left = 0;
        int right = array.length;
        int ans = -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] >= num) {
                right = mid;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    @Test
    void test1() {
        int[] array = {1, 1, 4, 4, 7};
        boolean exist = exist(array, 7);
        System.out.println(exist);
    }

    @Test
    void test2() {
        int[] array = {1, 1, 1, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5};
        int ans = find(array, 5);
        System.out.println(ans);
    }
}
