package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bt(root, p, q);
        return res;
    }

    TreeNode res;

    boolean[] bt(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new boolean[2];
        boolean[] left = bt(root.left, p, q);
        boolean[] right = bt(root.right, p, q);
        boolean foundP = root == p || left[0] || right[0];
        boolean foundQ = root == q || left[1] || right[1];
        if (foundP && foundQ) {
            res = root;
            return new boolean[2];
        }
        return new boolean[]{foundP, foundQ};
    }
}
