package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.QuickSort;

import java.util.Arrays;

class QuickSortTest {
    @Test
    void test() {
        int[] arr = {3, 2, 4, 1, 5, 2, 3, 1};
        int[] sort = Arrays.copyOf(arr, arr.length);
        QuickSort.quickSort(arr);
        Arrays.sort(sort);
        Assertions.assertArrayEquals(sort, arr);
    }

}