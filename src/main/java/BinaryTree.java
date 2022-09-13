import utils.TreeNode;

import java.util.*;

public class BinaryTree {
    public TreeNode root;

    private int idx;

    public BinaryTree(String str) {
        this.idx = 0;
        String[] strs = str.split(",");
        this.root = buildTree(strs);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    private TreeNode buildTree(String[] strs) {
        if ("null".equals(strs[idx])) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        TreeNode left = buildTree(strs);
        TreeNode right = buildTree(strs);
        root.left = left;
        root.right = right;
        return root;
    }

    public List<Integer> preOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = this.root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return list;
    }

    public List<Integer> inOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = this.root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }

    public List<Integer> postOrder() {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = this.root;
        TreeNode pre = null;
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
        return list;
    }

    public List<Integer> bfs() {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode p = this.root;
        if (p != null) {
            q.offerLast(p);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.pollFirst();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offerLast(curr.left);
                }
                if (curr.right != null) {
                    q.offerLast(curr.right);
                }
            }
        }
        return list;
    }
}


