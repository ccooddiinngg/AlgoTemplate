package Leetcode.Offer;

import Leetcode.TreeNode;
import org.junit.jupiter.api.Test;

public class O54 {
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    int res = 0;
    int count = 0;

    void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.right, k);
        count++;
        if (count == k) res = root.val;
        inOrder(root.left, k);
    }

    @Test
    void test() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        t3.left = t1;
        t3.right = t4;
        t1.right = t2;

        System.out.println(kthLargest(t3, 1));
    }
}
