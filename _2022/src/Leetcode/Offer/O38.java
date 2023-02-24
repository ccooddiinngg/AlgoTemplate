package Leetcode.Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class O38 {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        dfs(s.split(""), 0, new StringBuilder(), list);
        return list.toArray(String[]::new);
    }

    void dfs(String[] strs, int idx, StringBuilder path, List<String> list) {
        if (idx == strs.length) {
            list.add(path.toString());
            return;
        }
        Set<String> set = new HashSet<>();
        for (int i = idx; i < strs.length; i++) {
            if (!set.contains(strs[i])) {
                set.add(strs[i]);
                swap(strs, idx, i);
                path.append(strs[idx]);
                dfs(strs, idx + 1, path, list);
                swap(strs, idx, i);
                path.setLength(path.length() - 1);
            }
        }
    }

    void swap(String[] strs, int i, int j) {
        String t = strs[i];
        strs[i] = strs[j];
        strs[j] = t;
    }
}
