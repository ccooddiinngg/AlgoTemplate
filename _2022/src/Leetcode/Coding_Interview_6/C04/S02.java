package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

public class S02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int i, int j) {
        if (i > j) return null;
        if (i == j) {
            return new TreeNode(nums[i]);
        }
        int mid = i + (j - i + 1) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = build(nums, i, mid - 1);
        head.right = build(nums, mid + 1, j);
        return head;
    }
}
