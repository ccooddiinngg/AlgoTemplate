package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PermutationsTest {
    Permutations permutations = new Permutations();

    @Test
    void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permutations.permute(nums);
        Assertions.assertEquals("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]", list.toString());
    }

}