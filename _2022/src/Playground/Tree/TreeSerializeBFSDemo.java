package Playground.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSerializeBFSDemo {
    public static void main(String[] args) {
        String data = "4,2,6,1,3,5,7,null,null,null,null,null,null,null,null";
        TreeNode root = deserialize(data);
        String str = serialize(root);
        TreeNode node = deserialize(str);
        System.out.println(node.val);
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null").append(",");
            } else {
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        TreeNode root = bfs(strs);
        return root;
    }

    private static TreeNode bfs(String[] strs) {
        Queue<TreeNode> q = new LinkedList<>();
        int idx = 0;
        TreeNode root = strs[idx].equals("null") ? null : new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        q.offer(root);
        while (idx < strs.length) {
            TreeNode node = q.poll();
            node.left = strs[idx].equals("null") ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            if (node.left != null) q.offer(node.left);
            node.right = strs[idx].equals("null") ? null : new TreeNode(Integer.parseInt(strs[idx]));
            idx++;
            if (node.right != null) q.offer(node.right);
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
