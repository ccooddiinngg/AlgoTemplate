package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S06a {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val > p.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}
