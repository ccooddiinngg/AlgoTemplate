package Leetcode.Offer;

import Leetcode.TreeNode;

public class O68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    TreeNode res = null;

    boolean[] find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new boolean[2];
        boolean[] left = find(root.left, p, q);
        boolean[] right = find(root.right, p, q);
        boolean[] curr = new boolean[2];
        if (root == p) curr[0] = true;
        if (root == q) curr[1] = true;
        boolean foundP = curr[0] || left[0] || right[0];
        boolean foundQ = curr[1] || left[1] || right[1];
        if (foundP && foundQ && res == null) {
            res = root;
        }
        return new boolean[]{foundP, foundQ};
    }
}
