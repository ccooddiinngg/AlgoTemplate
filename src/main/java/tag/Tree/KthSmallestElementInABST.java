package tag.Tree;

import utils.TreeNode;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            count++;
            if (count == k) {
                break;
            }
            p = p.right;
        }
        return p.val;
    }
}
