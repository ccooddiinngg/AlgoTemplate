package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC756 {
    Map<String, List<String>> map;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();
        for (String str : allowed) {
            String key = str.substring(0, 2);
            String val = str.substring(2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(val);
        }

        return bt(bottom);
    }

    boolean bt(String s) {
        if (s.length() == 1) {
            return true;
        }
        List<String> next = new ArrayList<>();
        getNextLevel(s, 0, new StringBuilder(), next);
        if (next.size() == 0) return false;
        for (String str : next) {
            if (bt(str)) {
                return true;
            }
        }
        return false;
    }

    void getNextLevel(String s, int idx, StringBuilder path, List<String> list) {
        if (idx == s.length() - 1) {
            if (path.length() == s.length() - 1) {
                list.add(path.toString());
            }
            return;
        }

        String key = s.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;
        for (String val : map.get(key)) {
            path.append(val);
            getNextLevel(s, idx + 1, path, list);
            path.setLength(path.length() - 1);
        }
    }
}
