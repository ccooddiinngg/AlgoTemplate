package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root != p) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                pre = root;
                root = root.left;
            }
        }

        if (root.right != null) {
            root = root.right;
            while (root.left != null) root = root.left;
            return root;
        }
        return pre;
    }
}
