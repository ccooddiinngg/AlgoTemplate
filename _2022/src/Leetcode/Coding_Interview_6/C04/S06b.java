package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S06b {
    boolean found;
    TreeNode ans;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        inorder(root, p);
        return ans;
    }

    void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (root.val == p.val) {
            found = true;
        } else if (found) {
            ans = root;
            found = false;
        }
        inorder(root.right, p);
    }
}
