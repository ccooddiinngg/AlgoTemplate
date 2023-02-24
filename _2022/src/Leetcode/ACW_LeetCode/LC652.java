package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC652 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return list;
    }

    String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String str = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            list.add(root);
        }
        return str;
    }
}
