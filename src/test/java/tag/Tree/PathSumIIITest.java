package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

class PathSumIIITest {
    PathSumIII pathSumIII = new PathSumIII();

    @Test
    void test() {
        String s = "10,5,-3,3,2,null,11,3,-2,null,1";
        int targetSum = 8;
        BinaryTree binaryTree = new BinaryTree(s, 1);
        Assertions.assertEquals(3, pathSumIII.pathSum(binaryTree.root, targetSum));
    }

}