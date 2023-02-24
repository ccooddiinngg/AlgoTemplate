package Leetcode.MostLiked100;

import Leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node != null) {
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            } else {
                list.add(null);
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.replaceAll("[\\[\\]]", "").split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = buildNode(str, index++);
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.left = buildNode(str, index++);
            if (node.left != null) q.offer(node.left);
            node.right = buildNode(str, index++);
            if (node.right != null) q.offer(node.right);
        }
        return root;
    }

    public TreeNode buildNode(String[] str, int index) {
        if (index >= str.length || str[index].trim().equals("null")) {
            return null;
        }
        int val = Integer.parseInt(str[index].trim());
        return new TreeNode(val);
    }

    @Test
    void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;
        String data = serialize(n1);
        System.out.println(data);
        TreeNode root = deserialize(data);
    }
}
