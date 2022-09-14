package template;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import template.BinaryTree;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    static String str;

    @BeforeAll
    static void setup() {
        str = "1,2,null,4,null,null,3,5,null,null,null";
    }

    @Test
    void buildTree() {
        BinaryTree binaryTree = new BinaryTree(str);
        assertEquals(List.of(1, 2, 4, 3, 5), binaryTree.preOrder());
        assertEquals(List.of(2, 4, 1, 5, 3), binaryTree.inOrder());
        assertEquals(List.of(4, 2, 5, 3, 1), binaryTree.postOrder());
        assertEquals(List.of(1, 2, 3, 4, 5), binaryTree.bfs());
    }

    @Test
    void serialize() {
        BinaryTree binaryTree = new BinaryTree(str);
        assertEquals(str, binaryTree.serialize(binaryTree.root));
    }

}