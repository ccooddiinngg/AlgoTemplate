package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumTest {
    CombinationSum combinationSum = new CombinationSum();

    @Test
    void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = combinationSum.combinationSum(candidates, target);
        Assertions.assertEquals("[[2, 2, 3], [7]]", list.toString());
    }

}