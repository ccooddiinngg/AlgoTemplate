package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PermutationsIITest {
    PermutationsII permutationsII = new PermutationsII();

    @Test
    void test() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> list = permutationsII.permuteUnique(nums);
        Assertions.assertEquals("[[1, 1, 2], [1, 2, 1], [2, 1, 1]]", list.toString());
    }

}