package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S08 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        dfs(chars, "", list, new boolean[chars.length]);
        return list.toArray(new String[0]);
    }

    void dfs(char[] chars, String path, List<String> list, boolean[] visited) {
        if (path.length() == chars.length) {
            list.add(path);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (!visited[j] && chars[j] == chars[i]) {
                    found = true;
                    break;
                }
            }
            if (found) continue;
            visited[i] = true;
            dfs(chars, path + chars[i], list, visited);
            visited[i] = false;
        }
    }
}
