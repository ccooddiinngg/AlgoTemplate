package Leetcode.Coding_Interview_6.C04;

import Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S09 {
    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            list.add(path);
            return list;
        }
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        bfs(q, path, list);
        return list;
    }

    void bfs(List<TreeNode> q, List<Integer> path, List<List<Integer>> list) {
        if (q.isEmpty()) {
            list.add(new ArrayList<>(path));
            return;
        }
        ArrayList<TreeNode> copy = new ArrayList<>(q);
        for (int i = 0; i < q.size(); i++) {
            TreeNode curr = q.get(i);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
            path.add(curr.val);
            q.remove(curr);
            bfs(q, path, list);
            path.remove(path.size() - 1);
            q = new ArrayList<>(copy);
        }

    }
}
