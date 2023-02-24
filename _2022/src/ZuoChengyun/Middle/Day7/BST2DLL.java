package ZuoChengyun.Middle.Day7;

public class BST2DLL {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //return [head, tail]
    public static TreeNode[] build(TreeNode root) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] left = build(root.left);
        TreeNode[] right = build(root.right);

        root.left = left[1];
        if (left[1] != null) {
            left[1].right = root;
        }
        root.right = right[0];
        if (right[0] != null) {
            right[0].left = root;
        }
        return new TreeNode[]{left[0] == null ? root : left[0], right[1] == null ? root : right[1]};
    }
}
