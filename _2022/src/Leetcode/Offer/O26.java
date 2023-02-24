package Leetcode.Offer;

import Leetcode.TreeNode;

public class O26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        return find(A, B) || (A.left != null && isSubStructure(A.left, B)) || (A.right != null && isSubStructure(A.right, B));
    }

    boolean find(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val) return find(A.left, B.left) && find(A.right, B.right);
        return false;
    }
}
