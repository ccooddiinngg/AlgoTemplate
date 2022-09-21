package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import template.BinaryTree;
import utils.TreeNode;

import java.util.List;

class DeleteNodeInABSTTest {
    DeleteNodeInABST deleteNodeInABST = new DeleteNodeInABST();

    @Test
    void test() {
        String s = "5,3,6,2,4,null,7";
        int key = 3;
        BinaryTree binaryTree = new BinaryTree(s, 1);
        TreeNode root = deleteNodeInABST.deleteNode(binaryTree.root, key);
        List<String> res = binaryTree.bfs(root);
        Assertions.assertEquals("[5, 4, 6, 2, null, null, 7]", res.toString());
    }

}