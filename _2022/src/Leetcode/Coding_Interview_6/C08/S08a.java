package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S08a {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        List<String> list = new ArrayList<>();
        dfs(chars, 0, list);
        return list.toArray(new String[0]);
    }

    void dfs(char[] chars, int idx, List<String> list) {
        if (idx == chars.length) {
            list.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = idx; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, idx);
                dfs(chars, idx + 1, list);
                swap(chars, i, idx);
            }
        }
    }

    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}


