package Leetcode.MostLiked100;

import Leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (preorder.length == 0) {
//             return null;
//         }
//         if (preorder.length == 1) {
//             return new TreeNode(preorder[0]);
//         }
//         int rootVal = preorder[0];
//         int rootValIndex = indexOf(inorder, rootVal);

//         TreeNode root = new TreeNode(rootVal);
//         root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootValIndex), Arrays.copyOfRange(inorder, 0, rootValIndex));
//         root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootValIndex, preorder.length), Arrays.copyOfRange(inorder, rootValIndex + 1, inorder.length));
//         return root;

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length, indexMap);
    }

    private TreeNode helper(int[] pre, int[] in, int l1, int r1, int l2, int r2, Map<Integer, Integer> indexMap) {
        if (l1 == r1) {
            return null;
        }
        if (l1 == r1 - 1) {
            return new TreeNode(pre[l1]);
        }
        int val = pre[l1];
        int index = indexMap.get(val);
        int dis = index - l2;
        TreeNode root = new TreeNode(val);
        root.left = helper(pre, in, l1 + 1, l1 + 1 + dis, l2, l2 + dis, indexMap);
        root.right = helper(pre, in, l1 + 1 + dis, r1, l2 + 1 + dis, r2, indexMap);
        return root;
    }

    // private int indexOf(int[] inorder, int val) {
    //     int index = -1;
    //     for (int i = 0; i < inorder.length; i++) {
    //         if (inorder[i] == val) {
    //             index = i;
    //             break;
    //         }
    //     }
    //     return index;
    // }


    @Test
    void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
