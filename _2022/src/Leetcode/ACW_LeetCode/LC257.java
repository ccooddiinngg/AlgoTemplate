package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        bt(root, new StringBuilder(), list);
        return list;
    }

    void bt(TreeNode root, StringBuilder path, List<String> list) {
        if (root.left == null && root.right == null) {
            path.append(root.val);
            list.add(path.toString());
            return;
        }
        path.append(root.val).append("->");
        if (root.left != null) bt(root.left, new StringBuilder(path), list);
        if (root.right != null) bt(root.right, new StringBuilder(path), list);
    }
}
