package Playground.Tree;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    BinaryTree binaryTree = new BinaryTree();

    @Test
    void test() {
        binaryTree.deserialize("4,2,1,null,null,3,null,null,6,5,null,null,7,null,null", new DeserializerDFS());
        binaryTree.preorder();
        binaryTree.inorder();
        binaryTree.postorder();
        String data = binaryTree.serialize();
        System.out.println(data);
    }
}