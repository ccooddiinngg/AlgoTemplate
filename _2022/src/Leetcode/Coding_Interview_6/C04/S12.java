package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S12 {
    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return ans;
    }

    void helper(TreeNode root, int sum, int path, Map<Integer, Integer> map) {
        if (root == null) return;
        path += root.val;
        ans += map.getOrDefault(path - sum, 0);

        map.put(path, map.getOrDefault(path, 0) + 1);
        helper(root.left, sum, path, map);
        helper(root.right, sum, path, map);
        map.put(path, map.get(path) - 1);
    }
}
