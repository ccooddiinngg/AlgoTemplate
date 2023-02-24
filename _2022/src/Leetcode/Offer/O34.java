package Leetcode.Offer;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class O34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, target, new ArrayList<>(), list);
        return list;
    }

    void dfs(TreeNode curr, int target, List<Integer> path, List<List<Integer>> list) {
        if (curr.left == null && curr.right == null) {
            if (curr.val == target) {
                path.add(curr.val);
                list.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(curr.val);
        if (curr.left != null) dfs(curr.left, target - curr.val, path, list);
        if (curr.right != null) dfs(curr.right, target - curr.val, path, list);
        path.remove(path.size() - 1);
    }
}
