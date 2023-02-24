package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.Stack;

public class LC653 {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode p1 = root;
        while (p1 != null) {
            s1.push(p1);
            p1 = p1.left;
        }
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode p2 = root;
        while (p2 != null) {
            s2.push(p2);
            p2 = p2.right;
        }
        p1 = getNextP1(s1);
        p2 = getNextP2(s2);

        while (p1 != p2) {
            if (p1.val + p2.val == k) return true;
            if (p1.val + p2.val < k) {
                p1 = getNextP1(s1);
            } else {
                p2 = getNextP2(s2);
            }
        }
        return false;
    }

    TreeNode getNextP1(Stack<TreeNode> s1) {
        TreeNode p = s1.pop();
        TreeNode right = p.right;
        while (right != null) {
            s1.push(right);
            right = right.left;
        }
        return p;
    }

    TreeNode getNextP2(Stack<TreeNode> s2) {
        TreeNode p = s2.pop();
        TreeNode left = p.left;
        while (left != null) {
            s2.push(left);
            left = left.right;
        }
        return p;
    }
}
