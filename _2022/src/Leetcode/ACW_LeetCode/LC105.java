package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bt(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode bt(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (l1 > r1) return null;
        if (l1 == r1) return new TreeNode(pre[l1]);
        TreeNode root = new TreeNode(pre[l1]);
        int idx = indexOf(in, pre[l1]);
        int leftLen = idx - l2;
        root.left = bt(pre, l1 + 1, l1 + leftLen, in, l2, l2 + leftLen);
        root.right = bt(pre, l1 + leftLen + 1, r1, in, idx + 1, r2);
        return root;
    }

    int indexOf(int[] in, int t) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == t) return i;
        }
        return -1;
    }
}
