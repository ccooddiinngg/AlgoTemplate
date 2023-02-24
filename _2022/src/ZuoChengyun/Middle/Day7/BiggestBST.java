package ZuoChengyun.Middle.Day7;

public class BiggestBST {
    static class Info {
        int min;
        int max;
        boolean isBST;
        int maxCount;

        public Info(int min, int max, boolean isBST, int maxCount) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.maxCount = maxCount;
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Info find(Node root) {
        if (root.left == null && root.right == null) return new Info(root.val, root.val, true, 1);
        Info left = null, right = null;
        if (root.left != null) {
            left = find(root.left);
        }
        if (root.right != null) {
            right = find(root.right);
        }

        if (left == null) {
            if (right.isBST && root.val < right.min) {
                return new Info(root.val, right.max, true, right.maxCount + 1);
            } else {
                return new Info(0, 0, false, right.maxCount);
            }
        }
        if (right == null) {
            if (left.isBST && root.val > left.max) {
                return new Info(left.min, root.val, true, left.maxCount + 1);
            } else {
                return new Info(0, 0, false, left.maxCount);
            }
        }
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            return new Info(left.min, right.max, true, left.maxCount + right.maxCount + 1);
        } else {
            return new Info(0, 0, false, Math.max(left.maxCount, right.maxCount));
        }
    }
}
