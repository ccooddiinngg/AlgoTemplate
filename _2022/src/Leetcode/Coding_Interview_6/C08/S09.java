package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.List;

public class S09 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return list;
    }

    void dfs(int n, int l, int r, String path) {
        if (l + r == n * 2) {
            list.add(path);
            return;
        }
        if (l < n) {
            dfs(n, l + 1, r, path + "(");
        }
        if (r < l) {
            dfs(n, l, r + 1, path + ")");
        }
    }
}
