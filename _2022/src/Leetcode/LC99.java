package Leetcode;

import org.junit.jupiter.api.Test;

public class LC99 {
    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (n1 != null && n2 != null) {
            int t = n1.val;
            n1.val = n2.val;
            n2.val = t;
        }
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && root.val < pre.val) {
            n2 = root;
            if (n1 == null) {
                n1 = pre;
            }
        }
        pre = root;
        inorder(root.right);
    }

    @Test
    void test() {
        TreeNode root = Wrapper.stringToTreeNode("[1,3,null,null,2]");
        Wrapper.prettyPrintTree(root);
        recoverTree(root);
        Wrapper.prettyPrintTree(root);
    }
}
