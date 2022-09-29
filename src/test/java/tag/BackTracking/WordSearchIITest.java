package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordSearchIITest {
    WordSearchII wordSearchII = new WordSearchII();

    @Test
    void test() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> list = wordSearchII.findWords(board, words);
        Assertions.assertArrayEquals(List.of("oath", "eat").toArray(), list.toArray());
    }

}