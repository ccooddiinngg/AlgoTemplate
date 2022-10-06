package template;

public class AVLTree {
    TreeNode root;

    int getHeight(TreeNode x) {
        if (x == null) return 0;
        int left = x.left == null ? 0 : x.left.h;
        int right = x.right == null ? 0 : x.right.h;
        return left - right;
    }

    TreeNode leftRotate(TreeNode x) {
        if (x == null) return null;
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.h = Math.max(x.left.h, x.right.h) + 1;
        y.h = Math.max(y.left.h, y.right.h) + 1;
        return y;
    }

    TreeNode rightRotate(TreeNode x) {
        if (x == null) return null;
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.h = Math.max(x.left.h, x.right.h) + 1;
        y.h = Math.max(y.left.h, y.right.h) + 1;
        return y;
    }


    class TreeNode {
        public int val;
        public int h;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.h = 1;
        }
    }
}
