package ZuoChengyun.Middle.Day8;

import ZuoChengyun.Basic.Node;
import org.junit.jupiter.api.Test;

public class CompleteBinaryTreeNodeCount {
    public static int find(Node root) {
        if (root == null) return 0;
        int level = 0;
        Node curr = root;
        while (curr != null) {
            level++;
            curr = curr.left;
        }
        int rightLevel = 0;
        curr = root.right;
        while (curr != null) {
            rightLevel++;
            curr = curr.left;
        }
        if (rightLevel == level - 1) {
            return (1 << level - 1) - 1 + 1 + find(root.right);
        } else {
            return (1 << rightLevel) - 1 + 1 + find(root.left);
        }

    }

    @Test
    void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        System.out.println(find(node1));
    }
}
