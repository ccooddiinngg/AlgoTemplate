package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            int j = i + 10;
            String str = s.substring(i, j);
            if (list.contains(str)) continue;
            if (set.contains(str)) {
                list.add(str);
            }
            set.add(str);
        }
        return list;
    }
}
