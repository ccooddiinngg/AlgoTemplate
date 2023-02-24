package Leetcode.NeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@@ Find most occurrence char
public class N767 {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char maxChar = s.charAt(0);
        int maxCount = 0;
        int sum = 0;
        for (char key : map.keySet()) {

            if (map.get(key) >= maxCount) {
                maxCount = map.get(key);
                maxChar = key;
            }
            sum += map.get(key);
        }

        if (sum - maxCount < maxCount - 1) {
            return "";
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(maxChar));
            list.add(sb);
        }
        map.remove(maxChar);
        int index = 0;
        List<Character> restChars = new ArrayList<>();
        for (char key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                restChars.add(key);
            }

        }
        for (char restChar : restChars) {
            list.get(index % list.size()).append(String.valueOf(restChar));
            index++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}
