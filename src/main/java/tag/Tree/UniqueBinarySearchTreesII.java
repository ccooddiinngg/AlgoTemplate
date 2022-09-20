package tag.Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return build(n, 1, n);
    }

    List<TreeNode> build(int n, int l, int r) {
        List<TreeNode> list = new ArrayList<>();
        if (l > r) {
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> left = build(n, l, i - 1);
            List<TreeNode> right = build(n, i + 1, r);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nl;
                    root.right = nr;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
