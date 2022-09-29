package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

class SubtreeOfAnotherTreeTest {
    SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();

    @Test
    void test() {
        String s1 = "3,4,5,1,2,null,null,null,null,0";
        String s2 = "4,1,2";
        BinaryTree t1 = new BinaryTree(s1, 1);
        BinaryTree t2 = new BinaryTree(s2, 1);

        Assertions.assertFalse(subtreeOfAnotherTree.isSubtree(t1.root, t2.root));
    }

}