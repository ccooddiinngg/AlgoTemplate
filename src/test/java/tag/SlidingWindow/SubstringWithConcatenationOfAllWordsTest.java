package tag.SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubstringWithConcatenationOfAllWordsTest {
    SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();

    @Test
    void test() {
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c", "b", "a", "c", "a", "a", "a", "b", "c"};
//        [6,16,17,18,19,20]
        List<Integer> list = substringWithConcatenationOfAllWords.findSubstring(s, words);
        Assertions.assertArrayEquals(List.of(6, 16, 17, 18, 19, 20).toArray(), list.toArray());
    }

}