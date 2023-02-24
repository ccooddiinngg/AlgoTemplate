package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S08 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }

    boolean[] find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new boolean[2];
        boolean fp = root == p;
        boolean fq = root == q;
        boolean[] l = find(root.left, p, q);
        boolean[] r = find(root.right, p, q);
        fp = fp || l[0] || r[0];
        fq = fq || l[1] || r[1];
        if (fp && fq) {
            ans = root;
            return new boolean[2];
        }
        return new boolean[]{fp, fq};
    }
}
