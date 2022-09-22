package tag.DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CanIWinTest {
    CanIWin canIWin = new CanIWin();

    @Test
    void test() {
        int max = 20;
        int total = 210;
        assertFalse(canIWin.canIWin(max, total));
    }
    
}