package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameVTest {
    StoneGameV stoneGameV = new StoneGameV();

    @Test
    void test() {
        int[] stone = {6, 2, 3, 4, 5, 5};
        int actual = stoneGameV.stoneGameV(stone);
        Assertions.assertEquals(18, actual);
    }

}