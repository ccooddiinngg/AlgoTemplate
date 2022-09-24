package tag.Graph;

import org.junit.jupiter.api.Test;

class AlienDictionaryTest {
    AlienDictionary alienDictionary = new AlienDictionary();

    @Test
    void test() {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String res = alienDictionary.alienOrder(words);
        System.out.println(res);
    }

    @Test
    void test1() {
        String[] words = {"ac", "ab", "zc", "zb"};
        String res = alienDictionary.alienOrder(words);
        System.out.println(res);
    }

}