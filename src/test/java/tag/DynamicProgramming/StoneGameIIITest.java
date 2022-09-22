package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameIIITest {
    StoneGameIII stoneGameIII = new StoneGameIII();

    @Test
    void test() {
        int[] stone = {1, 2, 3, 7};
        Assertions.assertEquals("Bob", stoneGameIII.stoneGameIII(stone));
    }

}