package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.UnionFind;

class UnionFindTest {
    UnionFind unionFind = new UnionFind(10);

    @Test
    void test() {
        Assertions.assertFalse(unionFind.isSameSet(1, 4));
        Assertions.assertFalse(unionFind.isSameSet(1, 9));
        Assertions.assertFalse(unionFind.isSameSet(4, 9));

        unionFind.union(1, 4);
        unionFind.union(9, 4);
        Assertions.assertTrue(unionFind.isSameSet(1, 4));
        Assertions.assertTrue(unionFind.isSameSet(1, 9));
        Assertions.assertTrue(unionFind.isSameSet(4, 9));

        Assertions.assertFalse(unionFind.isSameSet(1, 8));
        Assertions.assertFalse(unionFind.isSameSet(4, 7));
    }
}