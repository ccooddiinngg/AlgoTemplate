import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrieTest {

    Trie trie = new Trie();

    @Test
    void test() {
        Assertions.assertFalse(trie.has("abc"));
        trie.insert("abc");
        Assertions.assertTrue(trie.has("abc"));
        Assertions.assertFalse(trie.has("ab"));
        Assertions.assertFalse(trie.has("a"));
        Assertions.assertFalse(trie.has("abcd"));
        trie.insert("abcd");
        Assertions.assertTrue(trie.has("abcd"));
    }
}