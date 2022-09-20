package tag.Tree;

import utils.TreeNode;

import java.util.Stack;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }

    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = null;

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null && root.val < pre.val) {
            if (n1 == null) {
                n1 = pre;
            }
            n2 = root;
        }
        pre = root;
        inOrder(root.right);
    }
    
    /*Iteration*/
    public void recoverTree1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode pre = null;
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null && p.val < pre.val) {
                if (n1 == null) {
                    n1 = pre;
                }
                n2 = p;
            }
            pre = p;
            p = p.right;
        }
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }
}
