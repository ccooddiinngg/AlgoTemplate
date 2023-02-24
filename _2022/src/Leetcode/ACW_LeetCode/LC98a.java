package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC98a {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null) {
            if (root.val <= pre.val) return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
