package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

class KthSmallestElementInABSTTest {
    KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();

    @Test
    void test() {
        String s = "5,3,6,2,4,null,null,1";
        int k = 3;
        BinaryTree binaryTree = new BinaryTree(s, 1);

        int res = kthSmallestElementInABST.kthSmallest(binaryTree.root, k);
        Assertions.assertEquals(3, res);
    }

}