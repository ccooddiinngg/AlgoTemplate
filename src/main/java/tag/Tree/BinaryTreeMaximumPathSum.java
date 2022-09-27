package tag.Tree;

import utils.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        bt(root);
        return MAX;
    }

    int MAX = Integer.MIN_VALUE;

    int bt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = bt(root.left);
        int right = bt(root.right);
        int maxChild = Math.max(left, right);
        int max = Math.max(root.val, root.val + maxChild);
        MAX = Math.max(MAX, Math.max(root.val, Math.max(left + root.val + right, maxChild + root.val)));
        return max;
    }
}
