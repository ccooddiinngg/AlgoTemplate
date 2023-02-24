package Leetcode.Coding_Interview_6.C17;

import Leetcode.TreeNode;

//从右向左中序遍历， 用pre记录前一个返回的节点
public class S12 {
    TreeNode pre;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return pre;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        root.right = pre;
        pre = root;
        helper(root.left);
        root.left = null;
    }
}
