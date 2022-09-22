package tag.DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PredictTheWinnerTest {
    PredictTheWinner predictTheWinner = new PredictTheWinner();

    @Test
    void test() {
        int[] nums = {1, 5, 233, 7};
        Assertions.assertTrue(predictTheWinner.predictTheWinner(nums));
    }

}