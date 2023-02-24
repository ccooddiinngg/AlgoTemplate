package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.Stack;

public class LC173 {
    class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode curr;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            push(root);
        }

        void push(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode curr = stack.pop();
            push(curr.right);
            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
