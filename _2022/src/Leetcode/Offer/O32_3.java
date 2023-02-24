package Leetcode.Offer;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class O32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        List<Integer> path = new ArrayList<>();
        boolean lToR = true;
        while (size > 0) {
            TreeNode curr = q.poll();
            if (lToR) {
                path.add(curr.val);
            } else {
                path.add(0, curr.val);
            }
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            size--;
            if (size == 0) {
                size = q.size();
                list.add(path);
                path = new ArrayList<>();
                lToR = !lToR;
            }
        }
        return list;
    }
}
