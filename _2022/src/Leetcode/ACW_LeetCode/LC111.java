package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC111 {
    //DFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        if (root.right != null) {
            right = minDepth(root.right);
        }

        return Math.min(left, right) + 1;
    }

    //BFS
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null && curr.right == null) {
                return level;
            }
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            size--;
            if (size == 0) {
                level++;
                size = q.size();
            }
        }
        return -1;
    }
}
