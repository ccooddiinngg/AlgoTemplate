package tag.Tree;

import utils.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bt(root, p, q);
        return ancestor;
    }

    TreeNode ancestor = null;

    boolean[] bt(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || ancestor != null) return new boolean[2];
        boolean[] left = bt(root.left, p, q);
        boolean[] right = bt(root.right, p, q);
        boolean foundP = root == p || left[0] || right[0];
        boolean foundQ = root == q || left[1] || right[1];
        if (ancestor == null && foundP && foundQ) {
            ancestor = root;
        }
        return new boolean[]{foundP, foundQ};
    }
}
