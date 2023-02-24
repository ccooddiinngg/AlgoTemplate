package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return bt(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean bt(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return bt(root.left, (long)min, (long)root.val) && bt(root.right, (long)root.val, (long)max);
    }
}
