package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.List;

public class S07 {
    public String[] permutation(String S) {
        List<String> list = new ArrayList<>();
        dfs(S.toCharArray(), new StringBuilder(), list, new int[256]);
        return list.toArray(new String[0]);
    }

    void dfs(char[] chars, StringBuilder path, List<String> list, int[] set) {
        if (path.length() == chars.length) {
            list.add(String.valueOf(path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (set[chars[i]] == 0) {
                set[chars[i]] = 1;
                path.append(chars[i]);
                dfs(chars, path, list, set);
                set[chars[i]] = 0;
                path.setLength(path.length() - 1);
            }
        }
    }
}
