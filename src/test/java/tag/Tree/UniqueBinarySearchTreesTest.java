package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniqueBinarySearchTreesTest {

    UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();

    @Test
    void test() {
        int n = 16;
        Assertions.assertEquals(35357670, uniqueBinarySearchTrees.numTrees(n));
    }

}