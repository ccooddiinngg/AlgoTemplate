package Leetcode.Offer;

import Leetcode.TreeNode;

public class O37 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            ser(root, sb);
            // System.out.println(sb);
            return sb.toString();
        }

        void ser(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(root.val).append(",");
            ser(root.left, sb);
            ser(root.right, sb);
        }

        // Decodes your encoded data to tree.
        int idx = 0;

        public TreeNode deserialize(String data) {
            String[] d = data.split(",");
            idx = 0;
            return des(d);
        }

        TreeNode des(String[] data) {
            if (data[idx].equals("null")) {
                idx++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data[idx++]));
            node.left = des(data);
            node.right = des(data);
            return node;
        }
    }
}
