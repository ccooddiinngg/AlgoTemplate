package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC337 {
    public int rob(TreeNode root) {
        int[] res = bt(root);
        return Math.max(res[0], res[1]);
    }

    int[] bt(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = bt(root.left);
        int[] right = bt(root.right);
        int pass = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = left[0] + right[0] + root.val;
        return new int[]{pass, rob};
    }
}
