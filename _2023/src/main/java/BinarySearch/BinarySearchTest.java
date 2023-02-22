package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    void test() {
        int[] nums = {1, 2, 2, 3, 5, 5};
        Assertions.assertEquals(1, binarySearch.searchGreaterEqual(nums, 2));
        Assertions.assertEquals(3, binarySearch.searchGreaterEqual(nums, 3));
        Assertions.assertEquals(2, binarySearch.searchLessEqual(nums, 2));
        Assertions.assertEquals(5, binarySearch.searchLessEqual(nums, 10));
    }

}