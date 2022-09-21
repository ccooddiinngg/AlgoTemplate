package template;

import utils.TreeNode;

import java.util.*;

public class BinaryTree {
    public TreeNode root;

    private int idx;

    //0:preorder dfs, 1: bfs
    public BinaryTree(String str, int method) {
        this.idx = 0;
        String[] strs = str.split(",");
        if (method == 0) {
            this.root = buildTreeDFS(strs);
        }
        if (method == 1) {
            buildTreeBFS(strs);
        }
    }

    public TreeNode find(int val) {
        t = null;
        find(root, val);
        return t;
    }

    private TreeNode t = null;

    private void find(TreeNode root, int val) {
        if (root == null || t != null) return;
        if (root.val == val) {
            t = root;
            return;
        }
        find(root.left, val);
        find(root.right, val);
    }

    private void buildTreeBFS(String[] strs) {
        Queue<TreeNode> q = new LinkedList<>();
        root = (idx >= strs.length || strs[idx].equals("null")) ? null : new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            curr.left = (idx >= strs.length || strs[idx].equals("null")) ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            curr.right = (idx >= strs.length || strs[idx].equals("null")) ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    public String serializeDFS(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = serializeDFS(root.left);
        String right = serializeDFS(root.right);
        return root.val + "," + left + "," + right;
    }

    private TreeNode buildTreeDFS(String[] strs) {
        if ("null".equals(strs[idx])) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        TreeNode left = buildTreeDFS(strs);
        TreeNode right = buildTreeDFS(strs);
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

    public List<String> bfs(TreeNode root) {
        List<String> list = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.pollFirst();
                if (curr == null) {
                    list.add("null");
                } else {
                    list.add(String.valueOf(curr.val));
                    q.offerLast(curr.left);
                    q.offerLast(curr.right);
                }
            }
        }
        while (list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        return list;
    }
}


