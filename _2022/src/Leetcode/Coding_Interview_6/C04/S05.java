package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S05 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
