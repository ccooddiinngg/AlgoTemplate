package Playground.Tree;

import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
    }

    public void deserialize(String data, Deserializer deserializer) {
        String[] strs = data.split(",");
        root = deserializer.deserialize(strs);
    }

    private int idx = 0;

    private TreeNode dfs(String[] strs) {
        if (strs[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        root.left = dfs(strs);
        root.right = dfs(strs);
        return root;
    }

    public String serialize() {
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + dfs(root.left) + "," + dfs(root.right);
    }

    //不是空就输出，压右边，去左边；是空就弹出
    public void preorder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.println(p);
                if (p.right != null) {
                    stack.push(p.right);
                }
                p = p.left;
            } else {
                p = stack.pop();
            }
        }
    }

    //压左边直到空，弹出输出，去右边
    public void inorder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p);
            p = p.right;
        }
    }

    //压左边直到空，弹出看右边为空或为pre，是就输出，pre为p，p为空，否就压p，去右边
    public void postorder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (p.right == null || p.right == pre) {
                System.out.println(p);
                pre = p;
                p = null;
            } else {
                stack.push(p);
                p = p.right;
            }
        }
    }
}
