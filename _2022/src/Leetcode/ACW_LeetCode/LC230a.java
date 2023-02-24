package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.Stack;

public class LC230a {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return 0;
    }
}
