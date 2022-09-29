package tag.Design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {
    @Test
    void test() {
        /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        */

        /*[null,null,null,1,null,-1,null,-1,3,4]*/

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assertions.assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        Assertions.assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        Assertions.assertEquals(-1, lruCache.get(1));
        Assertions.assertEquals(3, lruCache.get(3));
        Assertions.assertEquals(4, lruCache.get(4));
    }
}