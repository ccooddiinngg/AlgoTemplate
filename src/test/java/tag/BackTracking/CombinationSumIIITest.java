package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumIIITest {
    CombinationSumIII combinationSumIII = new CombinationSumIII();

    @Test
    void test() {
        int k = 3;
        int n = 7;
        List<List<Integer>> list = combinationSumIII.combinationSum3(k, n);
        Assertions.assertEquals("[[1, 2, 4]]", list.toString());
    }

}