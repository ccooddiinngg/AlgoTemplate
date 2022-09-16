package tag.BinaryIndexTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tag.DynamicProgramming.NumberOfLongestIncreasingSubsequence;

class NumberOfLongestIncreasingSubsequenceTest {
    NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();

    @Test
    void test() {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        Assertions.assertEquals(3, numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums));
    }

}