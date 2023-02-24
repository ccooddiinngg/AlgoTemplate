package AC2_Course.Trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrieTest {

    Trie trie = new Trie();

    @Test
    void add() {
        trie.add("t");
        trie.add("bike");
        trie.add("bob");
        trie.add("zoo");

//        Assertions.assertTrue(trie.hasPrefix("bik"));
        Assertions.assertTrue(trie.hasPrefix("bi"));
        Assertions.assertTrue(trie.hasPrefix("b"));
        Assertions.assertTrue(trie.hasPrefix(""));
        Assertions.assertTrue(trie.hasPrefix("zoo"));
        Assertions.assertTrue(trie.hasPrefix("t"));
        Assertions.assertTrue(trie.hasPrefix("bob"));
        Assertions.assertFalse(trie.hasPrefix("boob"));
        Assertions.assertFalse(trie.hasPrefix("ob"));

        Assertions.assertTrue(trie.hasWord("bike"));
        Assertions.assertTrue(trie.hasWord("bob"));
        Assertions.assertTrue(trie.hasWord("zoo"));
        Assertions.assertTrue(trie.hasWord("t"));
        Assertions.assertFalse(trie.hasWord("bikee"));
        Assertions.assertFalse(trie.hasWord("bi"));
        Assertions.assertFalse(trie.hasWord("bik"));
    }

}