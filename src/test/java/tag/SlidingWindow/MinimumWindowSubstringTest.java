package tag.SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumWindowSubstringTest {
    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    @Test
    void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Assertions.assertEquals("BANC", minimumWindowSubstring.minWindow(s, t));
    }

}