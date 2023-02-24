package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String ordered = helper(strs[i]);
            if (map.get(ordered) == null) {
                map.put(ordered, new ArrayList<>());
            }
            map.get(ordered).add(i);
        }
        List<List<String>> list = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> anagrams = new ArrayList<>();
            for (Integer i : map.get(key)) {
                anagrams.add(strs[i]);
            }
            list.add(anagrams);
        }
        return list;
    }

    public String helper(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    @Test
    void test() {
        String[] strs = {"abbc", "bacb", "cada"};
        System.out.println(groupAnagrams(strs));
    }
}
