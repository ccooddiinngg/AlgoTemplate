package Leetcode.ACW_LeetCode;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        return bt(1, n);
    }

    List<TreeNode> bt(int l, int r) {
        List<TreeNode> list = new ArrayList<>();
        if (l > r) {
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lefts = bt(l, i - 1);
            List<TreeNode> rights = bt(i + 1, r);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
