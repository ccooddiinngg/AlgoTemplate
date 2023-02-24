package ZuoChengyun.Basic.Day07;

import ZuoChengyun.Basic.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeWidth {

    public int getWidth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();

        int max = 0;
        int count = 0;
        q.add(root);
        Node end = root;
        Node nextEnd = null;
        while (!q.isEmpty()) {
            Node node = q.remove();
            count++;
            if (node.left != null) {
                q.add(node.left);
                nextEnd = node.left;
            }
            if (node.right != null) {
                q.add(node.right);
                nextEnd = node.right;
            }
            if (node == end) {
                max = Math.max(max, count);
                count = 0;
                end = nextEnd;
            }
        }
        return max;
    }
}
