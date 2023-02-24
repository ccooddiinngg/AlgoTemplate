package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC124 {
    public int maxPathSum(TreeNode root) {
        bt(root);
        return max;
    }
    int max = Integer.MIN_VALUE;

    int bt(TreeNode root) {
        if (root == null) return 0;
        int left = bt(root.left);
        int right = bt(root.right);
        int maxChild = Math.max(left, right);
        max = Math.max(max, Math.max(Math.max(root.val + left, root.val + right), Math.max(root.val, root.val + left + right)));
        return Math.max(root.val + maxChild, root.val);
    }
}
