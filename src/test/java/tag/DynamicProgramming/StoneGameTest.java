package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameTest {
    StoneGame stoneGame = new StoneGame();

    @Test
    void test() {
        int[] piles = {5, 3, 4, 5};
        Assertions.assertTrue(stoneGame.stoneGame(piles));
    }

}