package Leetcode.MostLiked100;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int tCount = tMap.size();

        int l = 0;
        int r = 0;
        int sCount = 0;

        int[] lenLeftRight = new int[]{-1, 0, 0};
        Map<Character, Integer> sMap = new HashMap<>();
        while (r < s.length()) {
            Character cr = s.charAt(r);
            sMap.put(cr, sMap.getOrDefault(cr, 0) + 1);
            //! equals
            if (tMap.containsKey(cr) && sMap.get(cr).intValue() == tMap.get(cr).intValue()) {
                sCount++;
            }

            while (l <= r && sCount == tCount) {
                Character cl = s.charAt(l);
                if (lenLeftRight[0] == -1 || r + 1 - l < lenLeftRight[0]) {
                    lenLeftRight[0] = r + 1 - l;
                    lenLeftRight[1] = l;
                    lenLeftRight[2] = r;
                }
                sMap.put(cl, sMap.get(cl) - 1);
                if (tMap.containsKey(cl) && sMap.get(cl) < tMap.get(cl)) {
                    sCount--;
                }
                l++;
            }
            r++;
        }
        return lenLeftRight[0] == -1 ? "" : s.substring(lenLeftRight[1], lenLeftRight[2] + 1);
    }

}
