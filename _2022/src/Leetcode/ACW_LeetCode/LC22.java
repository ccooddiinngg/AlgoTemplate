package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, 0, 0, 0, new StringBuilder(), list);
        return list;
    }

    void dfs(int n, int idx, int l, int r, StringBuilder path, List<String> list) {
        if (idx == n * 2) {
            list.add(path.toString());
            return;
        }
        if (l < n) {
            path.append("(");
            dfs(n, idx + 1, l + 1, r, path, list);
            path.setLength(path.length() - 1);
        }
        if (r < l) {
            path.append(")");
            dfs(n, idx + 1, l, r + 1, path, list);
            path.setLength(path.length() - 1);
        }
    }
}
