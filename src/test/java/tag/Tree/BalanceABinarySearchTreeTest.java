package tag.Tree;

import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.Stack;

class BalanceABinarySearchTreeTest {
    BalanceABinarySearchTree balanceABinarySearchTree = new BalanceABinarySearchTree();

    @Test
    void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        TreeNode root = balanceABinarySearchTree.balanceBST(n1);

        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val);
            p = p.right;
        }
    }

}