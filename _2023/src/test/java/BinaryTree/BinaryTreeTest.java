package BinaryTree;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    @Test
    void buildTree() {
        String str = "1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null";

        BinaryTree binaryTree = new BinaryTree(str);
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();
        binaryTree.bfs();
        System.out.println(binaryTree.serialize());
    }

}