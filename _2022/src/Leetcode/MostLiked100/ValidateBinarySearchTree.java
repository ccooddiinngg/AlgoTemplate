package Leetcode.MostLiked100;

import Leetcode.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root)[2] == 1;
    }

    public int[] helper(TreeNode node) {
        if (node == null) {
            return null;
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        if (left == null && right == null) {
            return new int[]{node.val, node.val, 1};
        } else if (left == null) {
            if (right[2] == 1 && node.val < right[0]) {
                return new int[]{node.val, right[1], 1};
            } else {
                return new int[]{0, 0, 0};
            }
        } else if (right == null) {
            if (left[2] == 1 && node.val > left[1]) {
                return new int[]{left[0], node.val, 1};
            } else {
                return new int[]{0, 0, 0};
            }
        } else {
            if (left[2] == 1 && right[2] == 1 && node.val > left[1] && node.val < right[0]) {
                return new int[]{left[0], right[1], 1};
            } else {
                return new int[]{0, 0, 0};
            }
        }

    }


}
