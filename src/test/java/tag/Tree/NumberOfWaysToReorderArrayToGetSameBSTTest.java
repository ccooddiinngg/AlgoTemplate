package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfWaysToReorderArrayToGetSameBSTTest {
    NumberOfWaysToReorderArrayToGetSameBST numberOfWaysToReorderArrayToGetSameBST = new NumberOfWaysToReorderArrayToGetSameBST();

    @Test
    void test() {
        int[] nums = {3, 4, 5, 1, 2};
        int res = numberOfWaysToReorderArrayToGetSameBST.numOfWays(nums);
        Assertions.assertEquals(5, res);
    }

}