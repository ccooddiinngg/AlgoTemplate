package Leetcode.NeetCode;

import Leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class N513 {

    //@@ DFS
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map, 0);
        int max = 0;
        for (int level : map.keySet()) {
            max = Math.max(max, level);
        }
        return map.get(max);
    }

    public void helper(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(level)) {
            map.put(level, root.val);
        }
        if (root.left != null) {
            helper(root.left, map, level + 1);
        }
        if (root.right != null) {
            helper(root.right, map, level + 1);
        }
    }

    //@@ BFS
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        TreeNode left = root;
        int size = 1;

        while (size > 0) {
            TreeNode node = q.poll();
            size--;
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            if (size == 0) {
                size = q.size();
                if (size > 0) {
                    left = q.peek();
                }
            }
        }
        return left.val;
    }
}
