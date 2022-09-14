package template;

import org.junit.jupiter.api.Test;
import template.BinarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    @Test
    void test() {
        int[] arr = {1, 3, 3, 5, 6, 6};
        assertEquals(-1, BinarySearch.findLessEqual(arr, 0));
        assertEquals(2, BinarySearch.findLessEqual(arr, 3));
        assertEquals(5, BinarySearch.findLessEqual(arr, 6));
        assertEquals(5, BinarySearch.findLessEqual(arr, 7));

        assertEquals(6, BinarySearch.findGreaterEqual(arr, 7));
        assertEquals(3, BinarySearch.findGreaterEqual(arr, 5));
        assertEquals(1, BinarySearch.findGreaterEqual(arr, 3));
        assertEquals(0, BinarySearch.findGreaterEqual(arr, 0));
    }

}