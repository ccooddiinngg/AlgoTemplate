package Leetcode.NeetCode;

import Leetcode.TreeNode;

public class N572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return equals(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean equals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }
}
