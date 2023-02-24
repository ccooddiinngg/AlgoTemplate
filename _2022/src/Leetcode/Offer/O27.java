package Leetcode.Offer;

import Leetcode.TreeNode;

public class O27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = mirrorTree(root.left);
        TreeNode r = mirrorTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}
