package Playground.Trie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrieTest {
    Trie trie = new Trie();

    @Test
    void test() {
        trie.insert("boot");
        trie.insert("boom");
        trie.insert("abs");
        trie.insert("ask");

        Assertions.assertFalse(trie.contains("boo"));
        Assertions.assertTrue(trie.contains("boot"));
        Assertions.assertTrue(trie.contains("ask"));
        Assertions.assertFalse(trie.contains("asks"));
        Assertions.assertTrue(trie.prefix("ask"));
        Assertions.assertTrue(trie.prefix("as"));
        Assertions.assertTrue(trie.prefix("a"));
    }
}