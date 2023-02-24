package Leetcode.Offer;

import Leetcode.TreeNode;

import java.util.*;

public class O32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            list.add(curr.val);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //use int array
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int[] res = new int[1010];
        int idx = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res[idx++] = curr.val;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}
