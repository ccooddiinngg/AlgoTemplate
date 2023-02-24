package Leetcode.ACW_LeetCode;

import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        return bt(s, 0, new int[s.length()], wordDict);
    }

    boolean bt(String s, int idx, int[] cache, List<String> wordDict) {
        if (idx == s.length()) return true;
        if (cache[idx] != 0) return cache[idx] == 1;
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (wordDict.contains(str)) {
                if (bt(s, i, cache, wordDict)) {
                    cache[idx] = 1;
                    return true;
                }
            }
        }
        cache[idx] = 2;
        return false;
    }
}
