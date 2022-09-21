package tag.Tree;

import utils.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    int[] dp(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int a = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int b = root.val + left[0] + right[0];
        return new int[]{a, b};
    }
}
