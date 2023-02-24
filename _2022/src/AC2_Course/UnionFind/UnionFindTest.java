package AC2_Course.UnionFind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UnionFindTest {
    UnionFind<Integer> unionFind = new UnionFind<>(List.of(1, 2, 3, 4, 5));

    @Test
    void test() {
        Assertions.assertEquals(1, unionFind.findParent(1).size);
        unionFind.union(1, 3);
        unionFind.union(1, 3);

        Assertions.assertEquals(2, unionFind.findParent(1).size);
        unionFind.union(2, 4);
        Assertions.assertFalse(unionFind.isSameSet(1, 2));
        Assertions.assertFalse(unionFind.isSameSet(3, 2));
        Assertions.assertTrue(unionFind.isSameSet(4, 2));
        Assertions.assertTrue(unionFind.isSameSet(1, 3));

        unionFind.union(1, 2);
        Assertions.assertEquals(4, unionFind.findParent(1).size);
        Assertions.assertTrue(unionFind.isSameSet(4, 3));
        Assertions.assertTrue(unionFind.isSameSet(1, 2));

        Assertions.assertEquals(4, unionFind.findParent(3).size);
    }
}