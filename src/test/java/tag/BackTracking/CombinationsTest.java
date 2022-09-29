package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationsTest {
    Combinations combinations = new Combinations();

    @Test
    void test() {
        int n = 4;
        int k = 2;
        List<List<Integer>> list = combinations.combine(n, k);
        Assertions.assertArrayEquals(List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4), List.of(3, 4)).toArray(), list.toArray());
    }

}