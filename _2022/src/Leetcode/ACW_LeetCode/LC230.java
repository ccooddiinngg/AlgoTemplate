package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC230 {
    TreeNode pre;
    TreeNode res;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        kthSmallest(root.left, k);
        if (pre == null) count = 0;
        pre = root;
        count++;
        if (count == k) res = root;
        kthSmallest(root.right, k);
        return res == null ? 0 : res.val;
    }
}
