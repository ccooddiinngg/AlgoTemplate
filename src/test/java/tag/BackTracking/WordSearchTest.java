package tag.BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearchTest {
    WordSearch wordSearch = new WordSearch();

    @Test
    void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        Assertions.assertTrue(wordSearch.exist(board, word));
    }

}