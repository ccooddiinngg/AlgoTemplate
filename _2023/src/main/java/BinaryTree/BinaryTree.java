package BinaryTree;

import java.util.*;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(String str) {
        String[] strs = Arrays.stream(str.split(",")).map(String::trim).toArray(String[]::new);
        this.root = deSerialize(strs);
    }

    private int idx = 0;

    public TreeNode deSerialize(String[] strs) {
        if (idx >= strs.length || "null".equals(strs[idx])) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        root.left = deSerialize(strs);
        root.right = deSerialize(strs);
        return root;
    }

    public String serialize() {
        return serialize(root);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public void preOrder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        System.out.println(list);
    }

    public void inOrder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        System.out.println(list);
    }

    public void postOrder() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (p.right == null || p.right == pre) {
                list.add(p.val);
                pre = p;
                p = null;
            } else {
                stack.push(p);
                p = p.right;
            }
        }
        System.out.println(list);
    }

    public void bfs() {
        Queue<TreeNode> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                list.add("null");
            } else {
                list.add(String.valueOf(node.val));
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        System.out.println(list);
    }
}
