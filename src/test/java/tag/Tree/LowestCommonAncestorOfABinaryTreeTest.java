package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;
import utils.TreeNode;

class LowestCommonAncestorOfABinaryTreeTest {
    LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();

    @Test
    void test() {
        String s = "3,5,1,6,2,0,8,null,null,7,4";
        BinaryTree binaryTree = new BinaryTree(s, 1);

        TreeNode p = binaryTree.find(5);
        TreeNode q = binaryTree.find(4);
        TreeNode res = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(binaryTree.root, p, q);
        Assertions.assertEquals(binaryTree.find(5), res);
    }

}