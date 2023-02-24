package Leetcode.Coding_Interview_6.C04;

import Leetcode.ListNode;
import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[1];
        }
        List<ListNode> list = new ArrayList<>();
        ListNode path = new ListNode(0);
        ListNode p = path;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        int size = q.size();
        while (size != 0) {
            TreeNode curr = q.poll();
            p.next = new ListNode(curr.val);
            p = p.next;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
            size--;
            if (size == 0) {
                list.add(path.next);
                path = new ListNode(0);
                p = path;
                size = q.size();
            }
        }
        return list.toArray(new ListNode[0]);
    }
}
