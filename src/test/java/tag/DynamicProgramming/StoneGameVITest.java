package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameVITest {
    StoneGameVI stoneGameVI = new StoneGameVI();

    @Test
    void test() {
        int[] a = {1, 3};
        int[] b = {2, 1};
        int res = stoneGameVI.stoneGameVI(a, b);
        Assertions.assertEquals(1, res);
    }

}