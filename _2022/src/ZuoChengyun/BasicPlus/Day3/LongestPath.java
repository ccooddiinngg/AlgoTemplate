package ZuoChengyun.BasicPlus.Day3;

import ZuoChengyun.Basic.Node;

public class LongestPath {
    public static int[] find(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = find(root.left);
        int[] right = find(root.right);
        int maxHeight = Math.max(left[0], right[0]) + 1;
        int maxDistance = Math.max(left[0] + right[0] + 1, Math.max(left[1], right[1]));

        return new int[]{maxHeight, maxDistance};
    }


}
