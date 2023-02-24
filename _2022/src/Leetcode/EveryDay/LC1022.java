package Leetcode.EveryDay;

import Leetcode.TreeNode;

public class LC1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
