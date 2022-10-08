package tag.Tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        AVL avl = new AVL();

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                avl.root = avl.insert(avl.root, p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }

        return avl.root;
    }

    static class AVL {
        TreeNode root;
        Map<TreeNode, Integer> map = new HashMap<>();

        int height(TreeNode x) {
            return map.get(x) == null ? 0 : map.get(x);
        }

        void setHeight(TreeNode x, int h) {
            map.put(x, h);
        }

        int getBalance(TreeNode x) {
            if (x == null) return 0;
            return height(x.left) - height(x.right);
        }

        TreeNode leftRotate(TreeNode x) {
            TreeNode y = x.right;
            x.right = y.left;
            y.left = x;
            setHeight(x, Math.max(height(x.left), height(x.right)) + 1);
            setHeight(y, Math.max(height(y.left), height(y.right)) + 1);
            return y;
        }

        TreeNode rightRotate(TreeNode x) {
            TreeNode y = x.left;
            x.left = y.right;
            y.right = x;
            setHeight(x, Math.max(height(x.left), height(x.right)) + 1);
            setHeight(y, Math.max(height(y.left), height(y.right)) + 1);
            return y;
        }

        TreeNode insert(TreeNode x, int val) {
            TreeNode node = new TreeNode(val);
            map.put(node, 1);
            if (x == null) return node;
            if (val < x.val) {
                x.left = insert(x.left, val);
            }
            if (val > x.val) {
                x.right = insert(x.right, val);
            }
            setHeight(x, Math.max(height(x.left), height(x.right)) + 1);
            int balance = getBalance(x);
            if (balance > 1) {
                if (height(x.left.left) <= height(x.left.right)) {
                    x.left = leftRotate(x.left);
                }
                return rightRotate(x);
            } else if (balance < -1) {
                if (height(x.right.right) <= height(x.right.left)) {
                    x.right = rightRotate(x.right);
                }
                return leftRotate(x);
            } else {
                return x;
            }
        }
    }
}
