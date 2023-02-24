package Leetcode.Offer;

import Leetcode.TreeNode;

public class O55_1 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
