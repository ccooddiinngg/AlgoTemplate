package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC99 {
    TreeNode w1 = null;
    TreeNode w2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        bt(root);
        int t = w1.val;
        w1.val = w2.val;
        w2.val = t;
    }

    void bt(TreeNode root) {
        if (root == null) return;
        bt(root.left);
        if (pre != null) {
            if (root.val <= pre.val) {
                if (w1 == null) {
                    w1 = pre;
                    w2 = root;
                }else {
                    w2 = root;
                }
            }
        }
        pre = root;
        bt(root.right);
    }
}
