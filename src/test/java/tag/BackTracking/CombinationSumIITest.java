package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumIITest {
    CombinationSumII combinationSumII = new CombinationSumII();

    @Test
    void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> list = combinationSumII.combinationSum2(candidates, target);
        Assertions.assertEquals("[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]", list.toString());
    }

}