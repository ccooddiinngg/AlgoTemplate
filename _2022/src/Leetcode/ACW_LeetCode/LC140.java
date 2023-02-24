package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        bt(s, wordDict, 0, new StringBuilder(), list);
        return list;
    }

    void bt(String s, List<String> wordDict, int idx, StringBuilder path, List<String> list) {
        if (idx == s.length()) {
            path.setLength(path.length() - 1);
            list.add(path.toString());
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (wordDict.contains(str)) {
                StringBuilder p = new StringBuilder(path);
                p.append(str).append(" ");
                bt(s, wordDict, i, p, list);
            }
        }
    }
}
