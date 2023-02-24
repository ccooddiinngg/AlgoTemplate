package Leetcode.Offer;

import Leetcode.TreeNode;

public class O55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) >= 0;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
