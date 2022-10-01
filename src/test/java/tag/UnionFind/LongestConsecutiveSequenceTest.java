package tag.UnionFind;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {
    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

    @Test
    void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int res = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(res);
    }

}