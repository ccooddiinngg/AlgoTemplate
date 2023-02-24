package ZuoChengyun.Basic.Day08;

import ZuoChengyun.Basic.BinaryTreePrinter;
import ZuoChengyun.Basic.Day07.Tree;
import ZuoChengyun.Basic.Node;

public class MaxDistance {
    static class Info {
        int height, maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static Info getMax(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info left = getMax(root.left);
        Info right = getMax(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance),
                left.height + right.height + 1);
        return new Info(height, maxDistance);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 8, null, null, 6, null, 7};
        Node root = Tree.deserialize(arr);
        BinaryTreePrinter.printNode(root);
        Info info = MaxDistance.getMax(root);
        System.out.println(info.maxDistance);
    }
}
