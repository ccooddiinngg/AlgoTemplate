package Leetcode.MostLiked100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        return helper(s, wordDict, 0, new HashMap<Integer, Boolean>());
    }

    public boolean helper(String s, List<String> wordDict, int index, Map<Integer, Boolean> cache) {
        if (cache.get(index) != null) {
            return cache.get(index);
        }
        if (index == s.length()) {
            return true;
        }
        boolean next = false;
        for (int i = 0; i < wordDict.size(); i++) {
            String w = wordDict.get(i);
            int p1 = index;
            int p2 = 0;
            while (p1 < s.length() && p2 < w.length() && s.charAt(p1) == w.charAt(p2)) {
                p1++;
                p2++;
            }
            if (p2 == w.length()) {
                //! using || , if found one, return true.
                next = next || helper(s, wordDict, index + p2, cache);
            }
        }
        cache.put(index, next);
        return next;
    }

}
