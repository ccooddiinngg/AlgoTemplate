package tag.SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SlidingWindowMaximumTest {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    @Test
    void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, slidingWindowMaximum.maxSlidingWindow(nums, k));
    }

}