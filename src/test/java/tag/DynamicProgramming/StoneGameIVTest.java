package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameIVTest {
    StoneGameIV stoneGameIV = new StoneGameIV();

    @Test
    void test() {
        int n = 1432;
        Assertions.assertFalse(stoneGameIV.winnerSquareGame(n));
    }

}