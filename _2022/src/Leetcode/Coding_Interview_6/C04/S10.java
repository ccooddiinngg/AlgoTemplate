package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S10 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (helper(t1, t2)) return true;
        if (t1 != null) {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
        return false;
    }

    boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && helper(t1.left, t2.left) && helper(t1.right, t2.right);
    }
}
