package tag.SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FindAllAnagramsInAStringTest {
    FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();

    @Test
    void test() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAllAnagramsInAString.findAnagrams(s, p);
        Assertions.assertArrayEquals(List.of(0, 6).toArray(), list.toArray());
    }

}