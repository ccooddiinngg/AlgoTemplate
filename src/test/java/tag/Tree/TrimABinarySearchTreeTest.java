package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;
import utils.TreeNode;

class TrimABinarySearchTreeTest {
    TrimABinarySearchTree trimABinarySearchTree = new TrimABinarySearchTree();

    @Test
    void test() {
        String s = "3,0,4,null,2,null,null,1";
        int low = 1;
        int high = 3;
        BinaryTree binaryTree = new BinaryTree(s, 1);

        TreeNode root = trimABinarySearchTree.trimBST(binaryTree.root, low, high);

        Assertions.assertEquals("[3, 2, null, 1]", binaryTree.bfs(root).toString());
    }

}