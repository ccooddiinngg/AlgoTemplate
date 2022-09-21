package tag.Tree;

import utils.TreeNode;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        //BST!
        if (root.val > key) {
            left = deleteNode(root.left, key);
        } else if (root.val < key) {
            right = deleteNode(root.right, key);
        } else {
            TreeNode p = right;
            if (p == null) {
                return left;
            } else {
                while (p.left != null) {
                    p = p.left;
                }
                p.left = left;
                return right;
            }
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
