package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return bt(root, root);
    }

    boolean bt(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return (r1.val == r2.val && bt(r1.left, r2.right) && bt(r1.right, r2.left));
    }
}
