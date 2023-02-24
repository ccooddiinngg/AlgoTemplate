package Playground.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializerBFS implements Deserializer {
    @Override
    public TreeNode deserialize(String[] strs) {
        return bfs(strs);
    }

    private TreeNode bfs(String[] strs) {
        Queue<TreeNode> q = new LinkedList<>();
        int idx = 0;
        if (strs[idx].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx]));
        q.offer(root);
        idx++;
        while (idx < strs.length) {
            TreeNode node = q.poll();
            if (!strs[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[idx]));
                q.offer(node.left);
            }
            idx++;
            if (!strs[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[idx]));
                q.offer(node.right);
            }
            idx++;
        }
        return root;
    }
}
