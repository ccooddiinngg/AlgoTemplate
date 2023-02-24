package ZuoChengyun.Basic.Day08;

import ZuoChengyun.Basic.BinaryTreePrinter;
import ZuoChengyun.Basic.Day07.Tree;
import ZuoChengyun.Basic.Node;

/*
平衡二叉树（Balanced BinaryTree）又被称为AVL树。
它具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
平衡二叉树一般是一个有序树，它具有二叉树的所有性质，其遍历操作和二叉树的遍历操作相同。
*/
public class BalancedBinaryTree {
    private static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info isAVL(Node root) {
        if (root == null) return new Info(true, 0);

        Info leftInfo = isAVL(root.left);
        Info rightInfo = isAVL(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 8, 5, null, 6, null, 7};
        Node root = Tree.deserialize(arr);
        BinaryTreePrinter.printNode(root);
        Info avl = BalancedBinaryTree.isAVL(root);
        System.out.println(avl.isBalanced + "  " + avl.height);
    }
}
