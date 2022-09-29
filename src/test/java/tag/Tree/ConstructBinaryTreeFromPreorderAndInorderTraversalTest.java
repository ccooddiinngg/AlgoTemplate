package tag.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    void test() {
        int[] pre = {1, 2, 3};
        int[] in = {2, 3, 1};
        TreeNode root = constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(pre, in);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        Assertions.assertArrayEquals(pre, list.stream().mapToInt(i -> i).toArray());
    }
}