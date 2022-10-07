package template;

public class AVLTree {
    TreeNode root;

    int height(TreeNode x) {
        if (x == null) return 0;
        return x.h;
    }

    int getBalance(TreeNode x) {
        if (x == null) return 0;
        return height(x.left) - height(x.right);
    }

    TreeNode leftRotate(TreeNode x) {
        if (x == null) return null;
        TreeNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.h = Math.max(height(x.left), height(x.right)) + 1;
        y.h = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    TreeNode rightRotate(TreeNode x) {
        if (x == null) return null;
        TreeNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.h = Math.max(height(x.left), height(x.right)) + 1;
        y.h = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        }
        if (val > root.val) {
            root.right = insert(root.right, val);
        }
        root.h = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // are 4 cases
        // Left Left Case
        if (balance > 1 && val < root.left.val)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && val > root.right.val)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
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
