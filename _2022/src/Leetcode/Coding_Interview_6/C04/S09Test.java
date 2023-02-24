package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;
import Leetcode.TreeNodeWrapper;
import org.junit.jupiter.api.Test;

class S09Test {
    TreeNode root;

    @Test
        //[5,2,8,1,3,6,null,null,null,null,4,null,7]
    void buildTreeNode() {
//        String s = "[5,2,8,1,3,6,null,null,null,null,4,null,7]";
        String s = "[4, 2, 5, 1, 3, null, 6]";
        root = TreeNodeWrapper.stringToTreeNode(s);
    }

    @Test
    void test() {
        buildTreeNode();
        S09 s09 = new S09();
        var list = s09.BSTSequences(root);
        for (var e : list) {
            System.out.println(e);
        }
    }

}