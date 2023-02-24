package Leetcode.Offer;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> path = new ArrayList<>();
        int size = q.size();
        while (size > 0) {
            TreeNode curr = q.poll();
            path.add(curr.val);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            size--;
            if (size == 0) {
                size = q.size();
                list.add(path);
                path = new ArrayList<>();
            }
        }
        return list;
    }
}
