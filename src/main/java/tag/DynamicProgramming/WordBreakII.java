package tag.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    int maxLen = 0;

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        for (String str : dict) {
            maxLen = Math.max(maxLen, str.length());
        }
        List<String> list = new ArrayList<>();
        bt(s, 0, dict, new ArrayList<>(), list);
        return list;
    }

    void bt(String s, int idx, Set<String> dict, List<String> path, List<String> list) {
        if (idx == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                sb.append(str).append(" ");
            }
            sb.setLength(sb.length() - 1);
            list.add(sb.toString());
            return;
        }
        for (int i = 1; i <= maxLen && idx + i <= s.length(); i++) {
            String sub = s.substring(idx, idx + i);
            if (dict.contains(sub)) {
                path.add(sub);
                bt(s, idx + i, dict, path, list);
                path.remove(path.size() - 1);
            }
        }
    }
}
