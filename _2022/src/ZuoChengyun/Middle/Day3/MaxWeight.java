package ZuoChengyun.Middle.Day3;

import ZuoChengyun.Basic.Node;

public class MaxWeight {
    public static int count(Node root) {
        if (root == null) return 0;
        int vLeft = count(root.left);
        int vRight = count(root.right);
        int v = root.val;
        return Math.max(vLeft, vRight) + v;
    }
}
