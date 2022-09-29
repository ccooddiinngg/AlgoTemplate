package tag.BreadthFirstSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WordLadderTest {
    WordLadder wordLadder = new WordLadder();

    @Test
    void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        int step = wordLadder.ladderLength(beginWord, endWord, wordList);
        Assertions.assertEquals(5, step);
    }

}