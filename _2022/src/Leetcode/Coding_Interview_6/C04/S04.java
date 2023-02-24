package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S04 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l, r) + 1;
    }
}
