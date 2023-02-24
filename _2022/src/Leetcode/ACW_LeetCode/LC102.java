package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return list;
        q.offer(root);
        int size = q.size();
        List<Integer> path = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            path.add(curr.val);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            size--;
            if (size == 0) {
                list.add(path);
                path = new ArrayList<>();
                size = q.size();
            }
        }
        return list;
    }
}
