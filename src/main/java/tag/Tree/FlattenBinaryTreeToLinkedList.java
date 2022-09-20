package tag.Tree;

import utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;
        pre = root;
    }

    /*reverse post order*/
}
