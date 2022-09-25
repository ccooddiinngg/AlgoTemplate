package tag.DynamicProgramming;

import utils.TreeNode;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = bt(root);
        return Math.max(res[0], res[1]);
    }

    int[] bt(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = bt(root.left);
        int[] right = bt(root.right);
        int yes = left[0] + right[0] + root.val;
        int no = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{no, yes};
    }
}
