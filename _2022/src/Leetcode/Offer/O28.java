package Leetcode.Offer;

import Leetcode.TreeNode;

public class O28 {
    public boolean isSymmetric(TreeNode root) {
        return find(root, root);
    }

    boolean find(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return r1.val == r2.val && find(r1.left, r2.right) && find(r1.right, r2.left);
    }
}
