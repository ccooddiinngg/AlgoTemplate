package tag.Tree;

import utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }

        int rootVal = pre[pl];
        int idx = -1;
        for (int i = il; i <= ir; i++) {
            if (in[i] == rootVal) {
                idx = i;
                break;
            }
        }
        int numOfLeft = idx - il;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, pl + 1, pl + numOfLeft, in, il, il + numOfLeft - 1);
        root.right = build(pre, pl + numOfLeft + 1, pr, in, idx + 1, ir);
        return root;
    }
}
