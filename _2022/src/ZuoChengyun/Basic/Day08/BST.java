package ZuoChengyun.Basic.Day08;

import ZuoChengyun.Basic.BinaryTreePrinter;
import ZuoChengyun.Basic.Day07.Tree;
import ZuoChengyun.Basic.Node;

public class BST {
    static class Info {
        boolean bst;
        int maxCount;
        int max;
        int min;

        public Info(boolean bst, int maxCount, int max, int min) {
            this.bst = bst;
            this.maxCount = maxCount;
            this.max = max;
            this.min = min;
        }
    }

    public static Info isBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info left = isBST(root.left);
        Info right = isBST(root.right);

        boolean bst = left.bst && right.bst && left.max < root.val && right.min > root.val;

        int maxCount = bst ? left.maxCount + right.maxCount + 1 : Math.max(left.maxCount, right.maxCount);
        int max = Math.max(Math.max(left.max, right.max), root.val);
        int min = Math.min(Math.min(left.min, right.min), root.val);

        return new Info(bst, maxCount, max, min);
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 4, 7, 1, 5};
        Node root = Tree.deserialize(arr);
        BinaryTreePrinter.printNode(root);
        Info info = BST.isBST(root);
        System.out.println(info.maxCount);
    }
}
