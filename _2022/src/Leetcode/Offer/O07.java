package Leetcode.Offer;

import Leetcode.TreeNode;

public class O07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return f(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode f(int[] pre, int[] in, int l1, int r1, int l2, int r2) {
        if (l1 > r1) return null;
        if (l1 == r1) {
            return new TreeNode(pre[l1]);
        }
        TreeNode head = new TreeNode(pre[l1]);
        int idx = indexOf(in, pre[l1]);
        head.left = f(pre, in, l1 + 1, l1 + idx - l2, l2, idx - 1);
        head.right = f(pre, in, l1 + idx - l2 + 1, r1, idx + 1, r2);
        return head;
    }

    int indexOf(int[] arr, int tar) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tar) return i;
        }
        return -1;
    }
}
